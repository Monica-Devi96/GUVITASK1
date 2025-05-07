package task4;
import java.util.Scanner;

public class DivisionbyZero {

	public static void main(String[] args) {
		int a,b,c;
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter two values");
		a=sc.nextInt();
		b=sc.nextInt();
		try{
           c=a/b;
           System.out.println("Division value is: "+c);
		}
		catch(ArithmeticException e) {
			System.out.println("Division by zero is not possible");
		}
	}

}
