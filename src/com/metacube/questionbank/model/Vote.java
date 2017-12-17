/**
 * 
 */
package com.metacube.questionbank.model;

/**
 * @author Admin39
 *
 */
public class Vote {
	private int answerId;
	private int questionId;
	private int upvoteStatus;

	public Vote(int answerId, int questionId, int upvoteStatus) {
		super();
		this.answerId = answerId;
		this.questionId = questionId;
		this.upvoteStatus = upvoteStatus;
	}

	public Vote() {
		super();
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getUpvoteStatus() {
		return upvoteStatus;
	}

	public void setUpvoteStatus(int upvoteStatus) {
		this.upvoteStatus = upvoteStatus;
	}

}
