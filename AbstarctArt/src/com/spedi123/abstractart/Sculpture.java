package com.spedi123.abstractart;

public class Sculpture extends Art {
	String material;
	
	public Sculpture(String title, String author, String description, String material) {
		super(title, author, description);
		this.material = material;
	}
	
	public void viewArt() {
		System.out.println("Title : " + getTitle() + ", Author : " + getAuthor() + ", Material : " + this.material);
		System.out.println("Description : " + getDescription());
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	
}
