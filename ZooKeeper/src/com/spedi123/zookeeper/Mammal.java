package com.spedi123.zookeeper;

public class Mammal {
	protected int energyLevel;
	
	public Mammal() {
		
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public int displayEnergy() {
		System.out.println("Energy level : " + energyLevel);
		return energyLevel;
	}

}
