package java_hw1_5_16_printing_program;
import java.util.Scanner;

public class Printing_program {
	
	public static void main(String[] args) {
		int check; // 用來檢查輸入的數字是否符合範圍
		int[] number = new int[5]; // 儲存使用者輸入的五個數字
		Scanner input = new Scanner(System.in); // 建立 Scanner 物件用於讀取輸入
		
		System.out.printf("Enter 5 numbers (1-30):\n");
		
		// 用迴圈輸入五次數字
		for (int i = 0; i < 5; i++) {
			System.out.printf("\nEnter number %d: ", i + 1); 
			check = input.nextInt(); // 讀取輸入的數字

			// 檢查數字是否在 1 到 30 的範圍內
			while (check < 1 || check > 30) {
				System.out.printf("The number is out of range!\nPlease input again\n"); // 輸入錯誤訊息
				System.out.printf("\nEnter number %d: ", i + 1); 
				check = input.nextInt(); // 重新讀取輸入的數字
			}
			number[i] = check; // 把有效的數字儲存到陣列裡
		}
		
		// 印出星號圖形
		System.out.printf("The star printing is:\n");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < number[i]; j++) { // 印出每個數字對應的星號
				System.out.printf("*");
			}
			System.out.printf("\n"); 
		}
		input.close();
	}
}
