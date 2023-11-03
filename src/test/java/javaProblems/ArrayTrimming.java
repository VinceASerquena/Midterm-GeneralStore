package javaProblems;

import java.util.ArrayList;
import java.util.List;

public class ArrayTrimming {
	public static void main(String args[]) {
		List<Integer> array1 = new ArrayList<>();
		List<Integer> array2 = new ArrayList<>();
		
		//add values to array 1
		array1.add(10);
		array1.add(20);
		array1.add(30);
		//add values to array 2
		array2.add(10);
		array2.add(20);
		array2.add(30);
		array2.add(40);
		
		System.out.println("Array 1: " + array1);
		System.out.println("Array 2: " + array2);
		
		//compare array
		compareArrayList(array1, array2);
		
		array2.remove(array2.size()-1);
		System.out.println("\nRemoved last element from 2nd array");
		System.out.println("Array 1: " + array1);
		System.out.println("Array 2: " + array2);
		compareArrayList(array1, array2);
	}
	
	public static void compareArrayList(List<Integer> a1, List<Integer> a2) {
		if (a1.equals(a2) == true) {
			System.out.println("Array lists are equal");
		}
		else {
			System.out.println("Array lists are not equal");
		}
	}
}
