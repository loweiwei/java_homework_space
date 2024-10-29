package java_hw1_4_19_sale_commission_caculator;
import java.util.Scanner;
public class Sale_commission_caculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int item;
		int account;
		double total = 0;
		char check = 'y';
		double itemlist[]  = { 239.99, 129.75, 99.95, 350.89};
		
		while(check == 'y') {
			System.out.printf("\nEnter the number of item you have saled:");
			item = input.nextInt();
			System.out.printf("\nEnter the account of item %d you have saled:",item);
			account = input.nextInt();
			
			total += itemlist[item-1]*account;//計算總金額
			
			System.out.printf("\nEnter again?[y/n]");
			check = input.next().charAt(0);
			input.nextLine();//吃掉剩餘的字元
		}
		
		System.out.printf("\nthe tatal earning is %.2f",total*0.09+200);	//計算收入	
	}

}
