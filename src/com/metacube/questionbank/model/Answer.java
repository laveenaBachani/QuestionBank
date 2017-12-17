package com.metacube.questionbank.model;

import java.sql.Timestamp;

public class Answer {
	private int ansId;
	private String answerDesc;
	private int userId;
	private Timestamp answerDate;
	private int questionId;

	public Answer(int ansId, String answerDesc, int userId,
			Timestamp answerDate, int questionId) {
		super();
		this.ansId = ansId;
		this.answerDesc = answerDesc;
		this.userId = userId;
		this.answerDate = answerDate;
		this.questionId = questionId;
	}

	public Answer() {
		// TODO Auto-generated constructor stub
	}

	public int getAnsId() {
		return ansId;
	}

	public void setAnsId(int ansId) {
		this.ansId = ansId;
	}

	public String getAnswerDesc() {
		return answerDesc;
	}

	public void setAnswerDesc(String answerDesc) {
		this.answerDesc = answerDesc;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(Timestamp answerDate) {
		this.answerDate = answerDate;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

}
