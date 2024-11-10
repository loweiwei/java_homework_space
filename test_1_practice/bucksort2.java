package BuckSort;
import java.util.Random;

public class bucksort2 {
    public static final int max = 10;
    public static final Random random = new Random();
    
    public static void bucketsort_(int[] unsortarray, int[][] bucket_, int maxlength) {
        for (int i = 0; i < maxlength; i++) {
            for (int j = 0; j < max; j++) {
                int digit = getdigit(unsortarray[j], i + 1);
                for (int k = 0; k < max; k++) {
                    if (bucket_[digit][k] != 0) continue;
                    bucket_[digit][k] = unsortarray[j];
                    break;
                }
            }
            gather(unsortarray, bucket_);
        }
    }
    
    public static int getdigit(int num, int i) {
        int k = -1;
        for (int j = 0; j < i; j++) {
            k = num % 10;
            num = num / 10;
        }
        return k;
    }
    
    public static void gather(int[] unsortarray, int[][] bucket_) {
        int count = 0;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                if (bucket_[i][j] == 0) break;
                unsortarray[count++] = bucket_[i][j];
                bucket_[i][j] = 0; // 清空桶中的元素，為下一位數的排序做準備
            }
        }
    }
    
    public static void main(String[] args) {
        int[] unsortarray = new int[max];
        int[][] bucket_ = new int[10][max];
        int maxlength = 0;
        
        System.out.println("未排序的陣列:");
        for (int i = 0; i < max; i++) {
            unsortarray[i] = random.nextInt(10, 1000);
            System.out.printf("%d ", unsortarray[i]);
        }
        
        // 獲取最大數字的位數，決定排序迭代次數
        for (int i = 0; i < max; i++) {
            int digit = (int) Math.log10(unsortarray[i]) + 1;
            maxlength = Math.max(maxlength, digit);
        }
        
        // 執行桶排序
        bucketsort_(unsortarray, bucket_, maxlength);
        
        System.out.println("\n\n排序後的陣列:");
        for (int i = 0; i < max; i++) {
            System.out.printf("%d ", unsortarray[i]);
        }
    }
}
