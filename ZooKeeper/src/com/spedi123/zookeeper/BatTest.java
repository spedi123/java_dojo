package com.spedi123.zookeeper;

public class BatTest {

	public static void main(String[] args) {
		Bat batMan = new Bat();
		
		batMan.displayEnergy();
		batMan.fly();
		batMan.attackTown(); 
		batMan.attackTown();
		batMan.attackTown();
		batMan.eatHumans();
		batMan.eatHumans();
		batMan.fly();
		batMan.displayEnergy();
	}
}
