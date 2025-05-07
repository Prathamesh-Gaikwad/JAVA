import javax.media.*;

class PlayVideo
{
	public static void main(String args[])throws Exception, javax.media.MediaException
	{
		String file = "sample_640x360.mpeg";
		
		Player player = Manager.createPlayer(file);
		
		player.realize();
		
		player.start();
		
		Thread.sleep(10000);
		
		player.stop();
		
		player.close();
	}
}

