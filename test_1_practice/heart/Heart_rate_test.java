package heart;
import java.util.Scanner;
public class Heart_rate_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String first,last;
		int[] birth = new int[3];
		Scanner input = new Scanner(System.in);
		System.out.printf("enter the first name:\n");
		first = input.nextLine();
		
		System.out.printf("enter the last name:\n");
		last = input.nextLine();
		System.out.printf("enter the date of birth(year month date):\n");
		for(int i = 0;i<3;i++) {
			birth[i]=input.nextInt();
		}
		HeartRate people1 = new HeartRate(first,last,birth);
		people1.info_show();
	}

}
