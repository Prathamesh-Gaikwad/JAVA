/*
 * @(#)ProgressThread.java	1.3 00/03/30
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

package jmapps.ui;

import javax.media.*;


/**
* This thread class is used by SaveAsDialog to monitor the progress of saving
* the file and updating the Progress dialog.
*/
public class ProgressThread extends Thread {

    private Processor       processor;
    private ProgressDialog  dlgProgress;
    private boolean         boolTerminate = false;
    private boolean         boolSuspended = false;


    /**
    * This constructor creates object ProgressThread.
    * @param    processor      processor, that does file save
    * @param    dlgProgress    Progress dialog
    */
    public ProgressThread ( Processor processor, ProgressDialog dlgProgress ) {
        this.processor = processor;
        this.dlgProgress = dlgProgress;
    }

    public synchronized void terminateNormaly () {
        boolTerminate = true;
    }

    public synchronized void pauseThread () {
        boolSuspended = true;
    }

    public synchronized void resumeThread () {
        boolSuspended = false;
        notify ();
    }


    /**
    *
    */
    public void run () {
        int    nPos;

        boolTerminate = false;
        while ( boolTerminate == false ) {
            try {
                sleep ( 200 );
                if ( boolSuspended == true ) {
                    synchronized ( this ) {
                        while ( boolSuspended )
                            wait ();
                    }
                }
            }
            catch ( Exception exception ) {
            }
            nPos = (int) processor.getMediaTime().getSeconds();
            dlgProgress.setCurPos ( nPos );
        }
    }
}


