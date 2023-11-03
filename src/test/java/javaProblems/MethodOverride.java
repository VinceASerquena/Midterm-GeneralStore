package javaProblems;

class Vehicle {
	public void speedUP() {
		System.out.println("Speed is 20 km/h");
	}
}

class Car extends Vehicle{
	public void speedUP() {
		System.out.println("Speed is 50 km/h");
	} 
}

class Bicycle extends Vehicle{
	public void speedUP() {
		System.out.println("Speed is 10 km/h");
	} 
}

public class MethodOverride {
	public static void main(String args[]) {
		Vehicle Vehicle1 = new Vehicle();
		Vehicle Vehicle2 = new Car();
		Vehicle Vehicle3 = new Bicycle();
		
		Vehicle1.speedUP();
		Vehicle2.speedUP();
		Vehicle3.speedUP();
	}
}
