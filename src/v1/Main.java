package v1;

public class Main {

	public static final int SCREEN_WIDTH = 1200;
	public static final int SCREEN_HEIGHT = 720;
	//해상도, 상수는 대문자로
	public static final int NOTE_SPEED = 3;
	//노트 떨어지는 속도가 7
	public static final int SLEEP_TIME = 10;
	public static final int REACH_TIME = 2;
	
	public static void main(String[] args) {

		new DynamicBeat();

	}

}
