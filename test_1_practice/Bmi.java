package BMI;
import java.util.Scanner;

public class Bmi {
	public static void main(String[] args) {
		double hight;
		double weight;
		double bmi;
		Scanner input = new Scanner(System.in);
		System.out.printf("enter height:\n");
		hight = input.nextDouble();
		System.out.printf("enter weight:\n");
		weight = input.nextDouble();
		
		bmi = weight/Math.pow(hight, hight);
		
		if (bmi < 18.5)
            System.out.println("Underweight");
        else if (bmi >= 18.5 && bmi < 25.0)
            System.out.println("Normal");
        else if (bmi >= 25.0 && bmi < 30.0)
            System.out.println("Overweight");
        else
            System.out.println("Obese");
	}
	

}
