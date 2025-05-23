/*
 * @(#)JMFUtils.java	1.1 00/02/10
 *
 * Copyright (c) 1999 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Sun grants you ("Licensee") a non-exclusive, royalty free, license to use,
 * modify and redistribute this software in source and binary code form,
 * provided that i) this copyright notice and license appear on all copies of
 * the software; and ii) Licensee does not utilize the software in a manner
 * which is disparaging to Sun.
 *
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING ANY
 * IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE OR
 * NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN AND ITS LICENSORS SHALL NOT BE
 * LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
 * OR DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR ITS
 * LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT,
 * INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER
 * CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF THE USE OF
 * OR INABILITY TO USE SOFTWARE, EVEN IF SUN HAS BEEN ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGES.
 *
 * This software is not designed or intended for use in on-line control of
 * aircraft, air traffic, aircraft navigation or aircraft communications; or in
 * the design, construction, operation or maintenance of any nuclear
 * facility. Licensee represents and warrants that it will not use or
 * redistribute the Software for such purposes.
 */


package jmapps.util;

import java.net.InetAddress;
import java.awt.*;

import javax.media.*;
import javax.media.protocol.*;
import javax.media.control.*;
import javax.media.bean.playerbean.*;
import javax.media.rtp.*;
import javax.media.rtp.rtcp.*;
import javax.media.format.AudioFormat;

import com.sun.media.util.JMFI18N;

import jmapps.ui.*;


public class JMFUtils {

    public static MediaPlayer createMediaPlayer ( String nameUrl, Frame frame ) {
        MediaLocator    mediaLocator = null;
        MediaPlayer     mediaPlayer = null;

        mediaLocator = new MediaLocator ( nameUrl );
        if ( mediaLocator == null  ||  nameUrl.equals("") ) {
            MessageDialog.createErrorDialog ( frame, JMFI18N.getResource("jmstudio.error.buildurlfor") + " " + nameUrl );
            return ( null );
        }

        mediaPlayer = new MediaPlayer ();
        mediaPlayer.setMediaLocator ( mediaLocator );
        if ( mediaPlayer.getPlayer() == null ) {
            MessageDialog.createErrorDialog ( frame, JMFI18N.getResource("jmstudio.error.player.createfor") + " " + nameUrl );
            return ( null );
        }

        return ( mediaPlayer );
    }

    public static MediaPlayer createMediaPlayer ( DataSource dataSource, Frame frame ) {
        MediaPlayer     mediaPlayer = null;

        if ( dataSource == null ) {
            MessageDialog.createErrorDialog ( frame, JMFI18N.getResource("jmstudio.error.player.createfor") + " " + dataSource );
            return ( null );
        }

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource( dataSource );
        if ( mediaPlayer.getPlayer() == null ) {
            MessageDialog.createErrorDialog ( frame, JMFI18N.getResource("jmstudio.error.player.createfor") + " " + dataSource );
            return ( null );
        }

        return ( mediaPlayer );
    }

    public static MediaPlayer createMediaPlayer ( Player player, Frame frame ) {
        MediaPlayer     mediaPlayer = null;

        if ( player == null ) {
            MessageDialog.createErrorDialog ( frame, JMFI18N.getResource("jmstudio.error.player.createfor") + " " + player );
            return ( null );
        }

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setPlayer ( player );
        if ( mediaPlayer.getPlayer() == null ) {
            MessageDialog.createErrorDialog ( frame, JMFI18N.getResource("jmstudio.error.player.createfor") + " " + player );
            return ( null );
        }

        return ( mediaPlayer );
    }

    // Creates capture DataSources for the requested device names and formats
    // Handles cases such as merging the two datasources, creating only
    // datasource if both device names are the same - that is, the device handles
    // both audio and video capture
    public static DataSource createCaptureDataSource ( String strAudioDevice,
                                                    Format audioFormat,
                                                    String strVideoDevice,
                                                    Format videoFormat ) {
    	DataSource  dsOne = null;
        DataSource  dsTwo = null;
        DataSource  sources [];
        DataSource  merged = null;

        if (strAudioDevice == null  &&  strVideoDevice == null)
            return null;

        if ( strAudioDevice == null  ||  strVideoDevice == null ) {
	    // Case 1 : Only one capture device

            // Figure out which device - audio or video - and create a datasource
            if (strAudioDevice != null)
            	dsOne = initializeCaptureDataSource ( null, strAudioDevice, audioFormat );
            else
                dsOne = initializeCaptureDataSource ( null, strVideoDevice, videoFormat );

        }
        else if ( !strAudioDevice.equals(strVideoDevice) ) {
	    // Case 2 : Different capture devices

            // create the ds for audio
            dsOne = initializeCaptureDataSource ( null, strAudioDevice, audioFormat );
            if ( dsOne == null )
            	return null;

            // create the ds for video
            dsTwo = initializeCaptureDataSource ( null, strVideoDevice, videoFormat );
            if (dsTwo == null)
            	return null;

            // Merge the two
            sources = new DataSource [] { dsOne, dsTwo };
            try {
            	merged = Manager.createMergingDataSource ( sources );
            }
            catch (javax.media.IncompatibleSourceException ise) {
            }
            dsOne = merged;
        } else {
	    // Case 3 : Both device names are the same.

            dsOne = initializeCaptureDataSource ( null, strAudioDevice, audioFormat);
            if (dsOne == null)
            	return null;
            dsOne = initializeCaptureDataSource ( dsOne, strVideoDevice, videoFormat);
        }

        if ( dsOne == null )
            return null;

    	try {
            dsOne.connect();
        }
        catch (java.io.IOException ioe) {
            return null;
        }
        return dsOne;
    }

    // Creates a DataSource for the given device name and sets the format on the
    // FormatControl exposed by the CaptureDevice (data source)
    //  Uses the specified data source ds or creates a new one if null
    public static DataSource initializeCaptureDataSource ( DataSource ds,
                                                        String deviceName,
                                                        Format format ) {
    	MediaLocator        deviceURL;
        CaptureDeviceInfo   cdi;
        DataSource          dataSource = null;
        FormatControl       formatControls [];
        Format              formats [];

        if ( ds == null ) {
            cdi = CaptureDeviceManager.getDevice ( deviceName );
            if (cdi == null)
            	return null;
            deviceURL = cdi.getLocator();

            try {
            	dataSource = Manager.createDataSource(deviceURL);
                if (dataSource == null)
                    return null;
            } catch (NoDataSourceException ndse) {
            	return null;
            } catch (java.io.IOException ioe) {
            	return null;
            }
        }

        if ( format == null )
            return dataSource;

        if ( format != null  &&  !(dataSource instanceof CaptureDevice) )
            return null;

        formatControls = ((CaptureDevice) dataSource).getFormatControls();
        if ( formatControls == null  ||  formatControls.length == 0 )
            return null;
        for ( int i = 0; i < formatControls.length; i++ ) {
            if ( formatControls[i] == null )
            	continue;
            formats = formatControls[i].getSupportedFormats();
            if (formats == null)
            	return null;
//            System.err.println("Trying format " + format);
            if (matches(format, formats) != null) {
            	formatControls[i].setFormat(format);
//                System.err.println("Matching format = " + format);
                return dataSource;
            }
        }
        return null;
    }

    private static Format matches ( Format format, Format supported[] ) {
        if ( supported == null )
            return null;
        for ( int i = 0;  i < supported.length;  i++ ) {
            if ( supported[i].matches(format) )
                return supported[i];
        }
        return null;
    }

    public static SessionManager createSessionManager ( String strAddress, String strPort, String strTtl )
    {
        int             nPort;
        int             nTtl;
        SessionManager  mngrSession;

        nPort = Integer.valueOf(strPort).intValue();
        nTtl = Integer.valueOf(strTtl).intValue();
        mngrSession = createSessionManager ( strAddress, nPort, nTtl );
        return ( mngrSession );
    }

    public static SessionManager createSessionManager ( String strAddress, int nPort, int nTtl )
    {
        SessionManager      mngrSession;
        String              nameUser = null;
        String              cname;
        SessionAddress      addrLocal;
        InetAddress         addrDest;
        SessionAddress      addrSession;
        SourceDescription   arrUserDescr [];


        mngrSession = (SessionManager) new com.sun.media.rtp.RTPSessionMgr ();
        if ( mngrSession == null )
            return null;

        mngrSession.addFormat ( new AudioFormat(AudioFormat.DVI_RTP,44100,4,1), 18 );

        // ask RTPSM to generate the local participants CNAME
        cname = mngrSession.generateCNAME ();
        try {
            nameUser = System.getProperty("user.name");
        } catch (SecurityException e){
            nameUser = "jmf-user";
        }

        // create our local Session Address
        addrLocal = new SessionAddress();
        try {
            addrDest = InetAddress.getByName ( strAddress );
            addrSession = new SessionAddress ( addrDest, nPort, addrDest, nPort + 1 );
            arrUserDescr = new SourceDescription []
            {
                new SourceDescription ( SourceDescription.SOURCE_DESC_EMAIL,
                                      "jmf-user@sun.com", 1, false ),
                new SourceDescription ( SourceDescription.SOURCE_DESC_CNAME,
                                      cname, 1, false ),
                new SourceDescription ( SourceDescription.SOURCE_DESC_TOOL,
                                      "JMF RTP Player v2.0", 1, false )
            };

            mngrSession.initSession ( addrLocal, arrUserDescr, 0.05, 0.25 );
            mngrSession.startSession ( addrSession, nTtl, null );
        }
        catch ( Exception e ) {
//            e.printStackTrace ();
            return null;
        }

        return mngrSession;
    }


}


