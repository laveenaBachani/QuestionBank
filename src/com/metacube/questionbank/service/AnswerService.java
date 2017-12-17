/**
 * 
 */
package com.metacube.questionbank.service;

import java.util.List;

import com.metacube.questionbank.model.Answer;

/**
 * @author Admin39
 *
 */
public interface AnswerService {
	public List<Answer> getAnswers(int qId);
}
