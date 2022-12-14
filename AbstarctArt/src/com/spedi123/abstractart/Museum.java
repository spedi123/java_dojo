package com.spedi123.abstractart;

import java.util.ArrayList;

public class Museum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Art> museum = new ArrayList<Art>();
		
		Painting paint1 = new Painting("title1","author1","description1","painttype1");
		Painting paint2 = new Painting("title2","author2","description2","painttype2");
		Painting paint3 = new Painting("title3","author3","description3","painttype3");
		museum.add(paint1);
		museum.add(paint2);
		museum.add(paint3);
		
		Sculpture sculpture1 = new Sculpture("title4","author4","description4","material1");
		Sculpture sculpture2 = new Sculpture("title5","author5","description5","material2");
		museum.add(sculpture1);
		museum.add(sculpture2);
		
		
		for (Art art:museum) {
			art.viewArt();
		}
		
	}

}
