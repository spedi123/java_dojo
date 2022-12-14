package com.spedi123.abstractart;

public class Painting extends Art {
	private String paintType;
	
	public Painting(String title, String author, String description, String paintType) {
		super(title, author, description);
		this.paintType = paintType;
	}
	
	public void viewArt() {
		System.out.println("Title : " + getTitle() + ", Author : " + getAuthor() + ", Paint Type : " + this.paintType);
		System.out.println("Description : " + getDescription());
	}

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}
	
	
}
