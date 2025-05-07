package task4;
import java.util.Scanner;

public class ValidAge {
	public void ValidateAge() throws InvalidAgeException{
		int age;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the age");
		age=sc.nextInt();
		sc.close();
		if(age<18) {
			throw new InvalidAgeException("Age should be greater than 18 and above");
		}
		else {
			System.out.println("You are eligible");
		}
	}
	
	public static void main(String[] args) {
        	ValidAge valid=new ValidAge();
        	try {
			valid.ValidateAge();
        	}
        	catch(InvalidAgeException e){
        		System.out.println("Exception caught:"+e.getMessage());
        	}
	}
}