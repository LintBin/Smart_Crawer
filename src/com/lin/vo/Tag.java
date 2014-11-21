package com.lin.vo;

public class Tag {
	private String tagName ;
	private String tagId;
	private String tagClass;
	
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getTagId() {
		return tagId;
	}
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	public String getTagClass() {
		return tagClass;
	}
	public void setTagClass(String tagClass) {
		this.tagClass = tagClass;
	}
	
	@Override
	public String toString() {
		return "Tag [tagName=" + tagName + ", tagId=" + tagId + ", tagClass="
				+ tagClass + "]";
	}
}
