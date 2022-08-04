package com.spedi123.demoproject;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello There");
		Human h1 = new Human();
		Orc h2 = new Orc();
		
		
		System.out.println("Human's health is : " + h1.health);
		System.out.println("Orc's health is : " + h2.health);
		
		h1.attack(h2);
		
		System.out.println("Human's health is : " +h1.health);
		System.out.println("Orc's health is : " +h2.health);
		
		h1.speak();
		
		
		
	}
	

}
