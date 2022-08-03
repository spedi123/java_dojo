package com.spedi123.demoproject;

public class Elf extends Race {

	public Elf() {
		// TODO Auto-generated constructor stub
		
		super();
		this.dexterity = 20;
		this.intelligence =20;
		this.health = 80;
	}
	
	public void attack(Race target) {
		target.health -= this.strength;
		System.out.println("Dealt" + this.strength + "damage.");
	}
	
	public void rest() {
		System.out.println("Resting...");
		this.health += 10;
	}
	
	public void eat() {
		System.out.println("Eat some pizza!");
		this.health += 40;
	}

}
