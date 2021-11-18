package v1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread  { //프로그램 속 하나의 작은 프로그램
	
	private Player player;
	private boolean isLoop;	//무한반복인지 아닌지
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {	//생성자
		try {	//try-catch문은 예외처리를 위해 사용
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" + name). toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);	//해당 파일 버퍼에 담아 읽어올수 있게 함
			player = new Player (bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getTime() {	//메소드, getTime : 실행되는 음악이 어떤 위치에 실행되고 있는지 알려줌
		if (player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close() {	//close 함수는 언제든지 음악 종료하게 해줌
		isLoop = false;
		player.close();
		this.interrupt();	//종료하게 해줌
	}
	
	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);	
				player = new Player(bis);
			} while (isLoop);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
