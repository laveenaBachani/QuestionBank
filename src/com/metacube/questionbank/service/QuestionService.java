/**
 * 
 */
package com.metacube.questionbank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metacube.questionbank.model.Question;

/**
 * @author Admin39
 *
 */
@Service
public interface QuestionService {
	public List<Question> getQuestions();
	public List<Question> getQuestions(int qId);
}
