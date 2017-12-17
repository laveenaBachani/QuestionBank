/**
 * 
 */
package com.metacube.questionbank.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.questionbank.dao.VoteDAO;
import com.metacube.questionbank.model.Answer;
import com.metacube.questionbank.service.VoteService;

/**
 * @author Admin39
 *
 */
public class VoteServiceImpl implements VoteService {
	@Autowired
	VoteDAO votedao;

	public int getUpvotesForAnswer(int anwId) {
		int count = votedao.getUpvotesForAnswer(anwId);
		return count;
	}

	public int getDownvotesForAnswer(int anwId) {
		int count = votedao.getdownvotesForAnswer(anwId);
		return count;
	}
	public ArrayList<Integer> getUpVotes(List<Answer> answers){
		ArrayList<Integer> upVotes=new ArrayList<Integer>();
		for (int index = 0; index < answers.size(); index++) {
			upVotes.add(getUpvotesForAnswer(answers.get(index).getAnsId()));
		}
		return upVotes;
		
	}
	public ArrayList<Integer> getDownVotes(List<Answer> answers){
		ArrayList<Integer> downVotes=new ArrayList<Integer>();
		for (int index = 0; index < answers.size(); index++) {
			downVotes.add(getUpvotesForAnswer(answers.get(index).getAnsId()));
		}
		return downVotes;
		
	}

}
