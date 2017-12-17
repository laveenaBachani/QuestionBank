package com.metacube.questionbank.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import com.metacube.questionbank.model.Answer;
import com.metacube.questionbank.model.Question;
import com.metacube.questionbank.service.impl.AnswerServiceImpl;
import com.metacube.questionbank.service.impl.QuestionServiceImpl;
import com.metacube.questionbank.service.impl.VoteServiceImpl;

@Controller
public class QuestionAnswerController {
	@Autowired
	AnswerServiceImpl quesAnswer;
	@Autowired
	QuestionServiceImpl question;
	@Autowired
	VoteServiceImpl votes;

	@RequestMapping(value = "QuestionAnswer.htm", method = RequestMethod.GET)
	public ModelAndView showQuestionAnswer(HttpServletRequest req) {

		int qId = Integer.parseInt(req.getParameter("id"));
		System.out.println(qId);
		List<Answer> questionAnswers = quesAnswer.getAnswers(qId);
		List<Question> ques = question.getQuestions(qId);
		ArrayList<Integer> upvotes = votes.getUpVotes(questionAnswers);
		ArrayList<Integer> downVotes = votes.getDownVotes(questionAnswers) ;
		List<Answer> answerLiked=quesAnswer.getAnswerLikedByUser(1);
		List<Answer> answeredByUser=quesAnswer.getAnswersByUserId(3);
		ModelAndView modelAndView = new ModelAndView("QuestionAnswer");
		req.setAttribute("answers", questionAnswers);
		req.setAttribute("question", ques);
		req.setAttribute("upvotes", upvotes);
		req.setAttribute("downVotes", downVotes);
		req.setAttribute("answerUser", answeredByUser);
		req.setAttribute("answerLiked", answerLiked);
		return modelAndView;
	}

	@RequestMapping(value = "QuestionAnswer.htm", method = RequestMethod.POST)
	public ModelAndView postAnswer(HttpServletRequest req) {
		
		String answer=req.getParameter("answer");
		Answer answerObj=new Answer();
		answerObj.setAnswerDesc(answer);
		int qId = Integer.parseInt(req.getParameter("id"));
		answerObj.setQuestionId(qId);
		answerObj.setUserId(1);
		quesAnswer.insertAnswer(answerObj);
		ModelAndView modelAndView = showQuestionAnswer(req);
		return modelAndView;
		
	}

	
	
	
}
