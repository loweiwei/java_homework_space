package java_hw1_5_17_student_grades;
import java.util.Scanner;

public class student_grades {

    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);
        String name; // 學生的名字
        char grades; // 學生的成績（單一字母）
        int counta = 0; // 用來統計成績為 A 的人數
        int countb = 0; // 用來統計成績為 B 的人數
        int countc = 0; // 用來統計成績為 C 的人數
        int countd = 0; // 用來統計成績為 D 的人數
        int countpeople = 0; // 計算已輸入的學生人數

        // 當輸入的學生數不等於 5 時，繼續進行迴圈
        while (countpeople != 5) {
            // 輸入學生名字
            System.out.printf("\nEnter the name of student %d: ", countpeople + 1);
            name = input.nextLine();

            // 輸入學生成績
            System.out.printf("\nEnter the grade of student %d: ", countpeople + 1);
            grades = input.next().charAt(0); // 讀取成績字母的第一個字元
            input.nextLine(); // 清除換行符號，避免影響下一次輸入

            // 使用 switch 
            switch (grades) {
                case 'A':
                case 'a': // 支援小寫
                    counta++; // A 成績數量加一
                    break;
                case 'B':
                case 'b': 
                    countb++; 
                    break;
                case 'C':
                case 'c': 
                    countc++; 
                    break;
                case 'D':
                case 'd': 
                    countd++; 
                    break;
                default:
                    System.out.printf("Invalid input"); // 當成績不符合 A-D 時顯示錯誤訊息
                    break;
            }
            countpeople++; // 學生數加一
        }

        // 成績的統計
        System.out.printf("\nNumber of grades 'A': " + counta);
        System.out.printf("\nNumber of grades 'B': " + countb);
        System.out.printf("\nNumber of grades 'C': " + countc);
        System.out.printf("\nNumber of grades 'D': " + countd);

        input.close(); 
    }
}
