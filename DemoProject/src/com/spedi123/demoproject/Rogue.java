package com.spedi123.demoproject;

public class Rogue extends Race {

	public Rogue() {
		// TODO Auto-generated constructor stub
		super();
		this.dexterity = 20;
	}
	
	public void attack(Race target) {
		target.health -= this.dexterity;
	}

}
