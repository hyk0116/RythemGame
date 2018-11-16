package RythemGame;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.File;


import javazoom.jl.player.Player;


public class Music extends Thread {
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fix;
	private BufferedInputStream bix;
	
	public Music(String name,boolean isleep) {
		try {
			this.isLoop=isLoop;
			file= new File(Main.class.getResource("../music/"+name).toURI());
			fix=new FileInputStream(file);
			bix=new BufferedInputStream(fix);
			player= new Player(bix);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
		public int getTime(){
			if (player==null)
			 return 0;
			return player.getPosition();
		
		}
		public void close() {
			isLoop= false;
			player.close();
			this.interrupt();
			
		}
		@Override
		public void run() {
			try {
				do {
					player.play();
					fix=new FileInputStream(file);
					bix=new BufferedInputStream(fix);
					player= new Player(bix);
				}while(isLoop);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		
		}
	
}

