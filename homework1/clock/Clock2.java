package clock2;

public class Clock2 {
	private int second;
	private int minute;
	private int hour;
	
	public Clock2() {
		this.second = 0;
		this.minute = 0;
		this.hour = 0;
	}
	
	public Clock2(int hour, int minute, int second) {
		if(0>hour||hour>23||minute<0||minute>59||second<0||second>59) {
			this.second = 0;
			this.minute = 0;
			this.hour = 0;
		}else{
			setSecond(second);
			setMinute(minute);
			setHour(hour);
		}
	}

	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		if(second>=60 || second<0 ) {
			this.second = 0;
			this.minute = 0;
			this.hour = 0;
			
		}else {
			this.second = second;
		}
	}
	
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		if(minute>=60 || minute<0) {
			this.second = 0;
			this.minute = 0;
			this.hour = 0;
		}else {
			this.minute = minute;
		}
	}
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		if(hour>=24 || hour<0) {
			this.second = 0;
			this.minute = 0;
			this.hour = 0;
		}else {
			this.hour = hour;
		}
	}
	
	public void showtime() {
		
		System.out.printf("the time is: %d: %d: %d\n", getHour(),getMinute(),getSecond());
	}
	
}
