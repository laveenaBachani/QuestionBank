/**
 * 
 */
package com.metacube.questionbank.service;

/**
 * @author Admin39
 *
 */
public interface VoteService {
	public int getUpvotesForAnswer(int anwId);
	public int getDownvotesForAnswer(int anwId);
}
