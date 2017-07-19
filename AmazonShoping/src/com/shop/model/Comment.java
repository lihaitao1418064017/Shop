package com.shop.model;

public class Comment {
	private int id;
	private String content;
	private Item item;
	public Item getItem() {
		
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getContent() {
		return content;
	}
	public int getId() {
		return id;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Comment [content=" + content + ", itemId=" ;
	}
	

}
