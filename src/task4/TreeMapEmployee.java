package task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapEmployee {

	public static void main(String[] args) {
		System.out.println("Tree Map for employee details");
		TreeMap<Integer,String> map=new TreeMap<>();
		map.put(101,"Abinaya");
		map.put(102,"Ramesh");
		map.put(103,"Ishwarya");
		map.put(104,"Siva");
		map.put(105,"Geetha");
		for(Map.Entry<Integer, String> entry : map.entrySet()) {
			
			System.out.println(entry.getKey()+"->" + entry.getValue());
		}
		ArrayList<String> names=new ArrayList<>(map.values());
		Collections.sort(names);
		System.out.println("Employee details in alphabetical order");
		for(String name:names) {
			System.out.println(name);
		}
		

	}

}
