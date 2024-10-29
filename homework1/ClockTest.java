package java_hw1_3_14_ClockTest;

public class ClockTest {

    public static void main(String[] args) {
        Clock time1 = new Clock(23, 34, 45);
        Clock time2 = new Clock(55, 65, 33); // 不合法的初始化
        
        System.out.printf("Time1: ");
        time1.displayTime();
        
        System.out.printf("Time2: ");
        time2.displayTime();
        
        time1.setHour(34); // 設置不合法的時間
        System.out.printf("Time1 (set hour to 34): ");
        time1.displayTime();
    }
}

class Clock {
    private int hour;
    private int minute;
    private int second;

    public Clock(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour >= 0 && hour <= 23) {
            this.hour = hour;
        } else {
            this.hour = 0; // 設為 0 如果不合法
        }
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        } else {
            this.minute = 0; // 設為 0 如果不合法
        }
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (second >= 0 && second <= 59) {
            this.second = second;
        } else {
            this.second = 0; // 設為 0 如果不合法
        }
    }

    public void displayTime() {
        System.out.printf("%02d:%02d:%02d\n", getHour(), getMinute(), getSecond());
    }
}
