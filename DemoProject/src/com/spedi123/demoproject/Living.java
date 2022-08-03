package com.spedi123.demoproject;

public interface Living {
	default void speak() {
		System.out.println("I am speaking!!!");
	}
	
	abstract void rest();
	
	abstract void eat();
}
