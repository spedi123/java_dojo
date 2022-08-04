package com.spedi123.zookeeper;

public class GorillaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gorilla KingKong = new Gorilla();
		
		KingKong.displayEnergy();
		
		KingKong.throwSomething();
		KingKong.throwSomething();
		KingKong.throwSomething();
		System.out.println(KingKong.getEnergyLevel());
		KingKong.eatBananas();
		KingKong.eatBananas();
		System.out.println(KingKong.getEnergyLevel());
		KingKong.climb();
		System.out.println(KingKong.getEnergyLevel());
	}

}
