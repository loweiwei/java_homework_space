package movie;
import java.util.Scanner;

public class movierecommend {
	static int people = 4;
	static int userinput = 3;
	
	public static int[][] reviewer = {{3, 1, 5, 2, 1, 5}, 
            {4, 2, 1, 4, 2, 4},
            {3, 1, 2, 4, 4, 1},
            {5, 1, 4, 2, 4, 2}};
	
	public static int nearst_movie(int[][] userreview) {
		double[] sum = new double[4];
		double min = 10000000;
		int index = -1;
		for( int i = 0;i<4;i++) {
			sum[i] = Math.abs(Math.sqrt(Math.pow(reviewer[i][userreview[0][0]-100] - userreview[0][1],2) + 
					Math.pow(reviewer[i][userreview[1][0]-100] - userreview[1][1],2) + 
					Math.pow(reviewer[i][userreview[2][0]-100] - userreview[2][1],2)));
			System.out.printf("%.2f\n", sum[i]);
		}
		for(int i = 0;i<4;i++) {
			if(min > sum[i]) {
				min = sum[i];
				index = i;
			}
		}
		return index;
	
	}
	
	public static void main(String[] args) {
		int[][] userreview =new  int[userinput][2];
		Scanner input = new Scanner(System.in);
		int preferuser ;
		
		System.out.printf("<Please enter 3 rating movie number and the review score:>\n");
		
		for(int i = 0;i<userinput;i++) {
			System.out.printf("%d movie number:\n",i+1);
			userreview[i][0] = input.nextInt();
			System.out.printf("%d movie rating score:\n",i+1);
			userreview[i][1] = input.nextInt();
		}
		
		preferuser = nearst_movie(userreview);
		System.out.printf("<You may also like :>\n");
		
		for(int i = 0;i<6;i++) {
			if( i+100 != userreview[0][0] && i != userreview[1][0] && i != userreview[2][0]) {
				System.out.printf("[%d,%d]",userreview[0][0],i+100);
				System.out.printf("movie numebr:%d\n rating: %d\n", i+100,reviewer[preferuser][i]);
			}
		}
		
		
	}

}
