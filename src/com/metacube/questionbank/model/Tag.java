/**
 * 
 */
package com.metacube.questionbank.model;

/**
 * @author Admin39
 *
 */
public class Tag {
	private int tagId;
	private String tagName;
	private String tagDesc;
	private Integer noOfQues;

	public Tag() {

	}

	public Tag(int tagId, String tagName, String tagDesc, Integer noOfQues) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
		this.tagDesc = tagDesc;
		this.noOfQues = noOfQues;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public Integer getNoOfQues() {
		return noOfQues;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagDesc() {
		return tagDesc;
	}

	public void setTagDesc(String tagDesc) {
		this.tagDesc = tagDesc;
	}

	public void setNoOfQues(Integer noOfQues) {
		this.noOfQues = noOfQues;
	}

}
