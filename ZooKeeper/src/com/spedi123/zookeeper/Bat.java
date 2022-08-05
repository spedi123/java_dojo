package com.spedi123.zookeeper;

public class Bat extends Mammal {
	
	public Bat() {
		super();
		this.energyLevel = 300;
	}
	
	public void fly() {
		System.out.println("ahhhhhhhh!");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		this.energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("no.....");
		this.energyLevel -= 100;
	}
}
