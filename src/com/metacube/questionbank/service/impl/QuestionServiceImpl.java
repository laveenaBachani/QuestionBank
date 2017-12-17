/**
 * 
 */
package com.metacube.questionbank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.questionbank.dao.QuestionDAO;
import com.metacube.questionbank.model.Question;
import com.metacube.questionbank.service.QuestionService;

/**
 * @author Admin39
 *
 */
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	QuestionDAO questionDAO;
	@Autowired
	VoteServiceImpl voteService;

	public List<Question> getQuestions() {
		return questionDAO.getQuestions();
	}

	public List<Question> getQuestions(int qId) {
		voteService.getUpvotesForAnswer(qId);
		return questionDAO.getQuestionById(qId);

	}

}
