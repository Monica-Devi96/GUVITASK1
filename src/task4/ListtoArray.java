package task4;

import java.util.LinkedList;

public class ListtoArray {

	public static void main(String[] args) {
		LinkedList<String> fruits=new LinkedList<>();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Guava");
		fruits.add("Pineapple");
		String[] arr=new String[fruits.size()];
		System.out.println("Elements in an array");
		for(int i=0;i<fruits.size();i++) {
			arr[i]=fruits.get(i);
		}
        for(String name:arr) {
        	System.out.println(name);
        }
	}

}
