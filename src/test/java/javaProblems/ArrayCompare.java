package javaProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayCompare {
	public static void main(String args[]) {

		List<Integer> myArray = new ArrayList<>();
		List<Integer> trimArray = new ArrayList<>();
		
		myArray.add(10);
		myArray.add(20);
		myArray.add(30);
		myArray.add(40);
		myArray.add(50);
		myArray.add(60);
		myArray.add(70);
		myArray.add(80);
		myArray.add(90);
		myArray.add(100);
		
		
		System.out.println("Size of array: " + myArray.size());
		System.out.print("Original Array: ");
		System.out.println(myArray);
		
		Scanner myScan = new Scanner(System.in);
		
		System.out.println("\nEnter array trim size: ");
		int trim = myScan.nextInt();
		trimArray = myArray.subList(0, trim);
		
		System.out.println("\nSize of trimmed array: " + trimArray.size());
		System.out.print("Trimmed Array: ");
		System.out.println(trimArray);
		
		myScan.close();
 	}
}
