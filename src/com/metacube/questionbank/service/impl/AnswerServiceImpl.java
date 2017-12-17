/**
 * 
 */
package com.metacube.questionbank.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.questionbank.dao.AnswerDAO;
import com.metacube.questionbank.model.Answer;
import com.metacube.questionbank.service.AnswerService;

/**
 * @author Admin39
 *
 */
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	AnswerDAO answerdao;

	public List<Answer> getAnswers(int qId) {
		return answerdao.getAnswers(qId);

	}

	public List<Answer> getAnswersByUserId(int userId) {

		return answerdao.getAnswersByUserId(userId);

	}

	public List<Answer> getAnswerLikedByUser(int userId) {
		return answerdao.getAnswerLikedByUser(userId);
	}
	
	
	public void insertAnswer(Answer answer){
		answerdao.insertAnswer(answer);
	}
}
