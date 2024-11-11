package clock2;

public class clock2_test {

	public static void main(String[] args) {
		Clock2 clock1 = new Clock2(12,13,20);
		Clock2 clock2 = new Clock2(19,24,99);
		
		clock1.showtime();
		clock2.showtime();
		
		clock1.setHour(-1);

		clock1.showtime();
		clock1.setHour(1);
		clock1.showtime();
	}

}

