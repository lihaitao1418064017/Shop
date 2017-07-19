package com.shop.action;

import com.shop.baseaction.AbstractJsonAction;
import com.shop.service.CommentService;

public class AddCommentListAction extends AbstractJsonAction {
	private String name;
	private String content;
	private int i;//商品下表
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	protected Object buildJsonObject() throws Exception {
		CommentService.addComment(content, name,i);
		return null;
	}
	
}
