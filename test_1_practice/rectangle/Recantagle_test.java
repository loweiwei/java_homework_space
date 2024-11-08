package reactangle;
import java.util.Scanner;
public class Recantagle_test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Rectangle[] R = new Rectangle[3];
		
		System.out.printf("Enter the three rectangle infomation:\n");
		
		for(int i = 0;i<3;i++) {
			System.out.printf("Enter the %d rectangle (x1,y1),(x2,y2):\n",i+1);
			R[i] = new Rectangle(input.nextInt(),input.nextInt(),input.nextInt(),input.nextInt());
		}
		
		for(int i = 0;i<3;i++) {
			System.out.printf("\n------------------------------------\n");
			R[i].show_recantagle_info();
		}
	}

}
