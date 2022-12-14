package com.spedi123.demoproject;

public abstract class Race {

	protected int strength;
	protected int dexterity;
	protected int intelligence;
	protected int health;
	
	public Race() {
		this.strength = 10;
		this.dexterity = 10;
		this.intelligence = 10;
		this.health = 100;
	}
	
	abstract void rest();
	
	abstract void eat();
}
