package studentgrades;
import java.util.Scanner;
public class studentgrades {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int counta = 0;
		int countb = 0;
		int countc = 0;
		int countd = 0;
		String[] studentname = new String[5];
		char[] getgrades = new char[5];
		for(int i = 0;i<5;i++) {
			System.out.printf("Enter the %d student name:", i+1);
			studentname[i] = input.nextLine();
			System.out.printf("Enter %s grades:", studentname[i]);
			getgrades[i] = input.next().charAt(0);
			input.nextLine();
			switch(getgrades[i]) {
			case 'a':
			case 'A':
				counta++;
				break;
			case 'b':
			case 'B':
				countb++;
				break;
			case 'c':
			case 'C':
				countc++;
				break;
			case 'D':
			case 'd':
				countd++;
				break;
			default:
				break;
			}
		}
		
		for(int i  = 0;i<5;i++) {
			System.out.printf("name:%s\ngrades:%s\n\n", studentname[i],getgrades[i]);
		}
		System.out.printf("total grades count:\n");
		System.out.printf("A:%d\n",counta);
		System.out.printf("B:%d\n",countb);
		System.out.printf("C:%d\n",countc);
		System.out.printf("D:%d\n",countd);
		
		
		
		
		

	}

}
