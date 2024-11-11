package rabbit;
import java.util.Random;

public class Rabbit_Turtose {
	public static void main(String[] args) {
		int rabbit_position = 1;
		int tortose_position = 1;
		int count = 0;
		int again = 1;
		Random random = new Random();
		int randomnum;
		System.out.printf("BANG!!!!!\r\n"
				+ "AND THEY'RE OFF!!!!!");
		while(again == 1) {
			while(rabbit_position<70 && tortose_position<70) {
				System.out.printf("<clock %d>\n",count);
				//turtose
				randomnum = random.nextInt(10);
				if(0<=randomnum && randomnum<=4 ) {
					tortose_position+=3;
				}else if(5<=randomnum && randomnum<=6) {
					tortose_position-=6;
				}else if(7<=randomnum && randomnum<=9) {
					tortose_position++;
				}
				if(tortose_position<1) {
					tortose_position = 1;
				}
				
				randomnum = random.nextInt(10);
				if(0<=randomnum && randomnum<=1) {
					rabbit_position+=0;
				}else if(2<=randomnum && randomnum<=3) {
					rabbit_position+=9;
				}else if(randomnum==4) {
					rabbit_position-= 12;
				}else if(5<=randomnum && randomnum<=7) {
					rabbit_position++;
				}else if(8<=randomnum && randomnum<=9) {
					rabbit_position-=2;
				}
				if(rabbit_position<1) {
					rabbit_position = 1;
				}
				System.out.printf("tortose position is now at%d\nrabbit position is now at%d\n",
						tortose_position,rabbit_position);
				
				if(rabbit_position == tortose_position) {
					show_position("OUTH",rabbit_position,"",1000);
				}else {
					show_position("r",rabbit_position,"t",tortose_position);
				}
				System.out.printf("\n");
				count++;
			}
			
			
			
			if(rabbit_position >tortose_position) {
				System.out.printf("rabbit win\n");
				again = 0;
			}else if(rabbit_position < tortose_position) {
				System.out.printf("tortose win\n");
				again = 0;
			}else if(rabbit_position ==tortose_position) {
				System.out.printf("one more time\n");
				again = 1;
				rabbit_position = 1;
				tortose_position = 1;
			}
		}
		
	}

	public static void show_position(String a,int a_pos,String b,int b_pos){
		for(int i = 0;i<=80;i++) {
			
			if(i == a_pos ) {
				System.out.printf("%s", a);
			}else if(i == b_pos) {
				System.out.printf("%s", b);
			}else {
				System.out.printf("_");
			}
		}
		System.out.printf("\n");
	}
}
