package com.metacube.questionbank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.metacube.questionbank.model.Question;
import com.metacube.questionbank.service.impl.QuestionServiceImpl;

@Controller
public class QuestionController {
	@Autowired
	QuestionServiceImpl questionservice;
	@RequestMapping(value="Questions.htm")
	public ModelAndView showQuestions(HttpServletRequest req){
		List<Question> questions= questionservice.getQuestions();	
		System.out.println(questions + "in  con");
		ModelAndView modelAndView=new ModelAndView("displayQuestions");
		req.setAttribute("questions",  questions);
		return modelAndView;
	}





}
