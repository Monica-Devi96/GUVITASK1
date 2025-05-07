package task4;
import java.util.ArrayList;
public class ArrayListOfString {

	public static void main(String[] args) {
		ArrayList <String> names=new ArrayList<String>();
		names.add("Monica");
		names.add("Dharsik");
		names.add("Kiruthikaa");
		names.add("Thiyaash");
		names.add("Latha");
		System.out.println("The Names in the list:");
		for(String str:names) {
			System.out.println(str+"  ");
		}
		System.out.println();
		names.clear();
		System.out.println("ArrayList After removing: "+names);
		}
	}

