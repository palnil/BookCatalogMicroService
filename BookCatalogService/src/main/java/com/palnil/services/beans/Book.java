package com.palnil.services.beans;

public class Book {

	private int id;
	private String title;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("Book.id: " + id);
		buffer.append("\nBook.title: " + title);
		return buffer.toString();
	}
	
    
}