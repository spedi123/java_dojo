package com.spedi123.zookeeper;

public class Gorilla extends Mammal {
	
	public Gorilla() {
		
	}
	
	public int getEnergyLevel() {
		return super.getEnergyLevel();
	}
	
	public void throwSomething() {
		System.out.println("Gorilla is throwing ... ");
		this.energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.println("Gorilla is eating bananas ... ");
		this.energyLevel += 10;
	}
	
	public void climb() {
		System.out.println("Gorilla is climbing ... ");
		this.energyLevel -= 10;
	}
}
