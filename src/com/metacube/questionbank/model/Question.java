/**
 * 
 */
package com.metacube.questionbank.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Admin39
 *
 */
public class Question {
	private int quesId;
	private String questionTitle;
	private String questionDesc;
	private int userId;
	private Timestamp questionDate;
	private Date closingDate;

	public int getQuesId() {
		return quesId;
	}

	public Question(int quesId, String questionTitle, String questionDesc,
			int userId, Timestamp questionDate, Date closingDate) {
		super();
		this.quesId = quesId;
		this.questionTitle = questionTitle;
		this.questionDesc = questionDesc;
		this.userId = userId;
		this.questionDate = questionDate;
		this.closingDate = closingDate;
	}

	public Question() {
		
	}

	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestionDesc() {
		return questionDesc;
	}

	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(Timestamp questionDate) {
		this.questionDate = questionDate;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}
}
