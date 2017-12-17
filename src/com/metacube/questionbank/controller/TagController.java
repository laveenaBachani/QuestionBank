package com.metacube.questionbank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import com.metacube.questionbank.model.Question;
import com.metacube.questionbank.model.Tag;
import com.metacube.questionbank.service.impl.TagServiceImpl;

@Controller
public class TagController {
	
	@Autowired
	TagServiceImpl tagService;
	@RequestMapping(value="tags.htm")
	public ModelAndView showTags(HttpServletRequest req){
		List<Tag> tags= tagService.getTags();
		
		ModelAndView modelAndView=new ModelAndView("tags");
		req.setAttribute("tags",  tags);
		return modelAndView;
	}
	
	@RequestMapping(value="tag_questions.htm",method=RequestMethod.GET)
	public ModelAndView showTagQuestions(HttpServletRequest req){
		int  i=Integer.parseInt(req.getParameter("id"));
		List<Question> tagQuestions= tagService.getTagQuestions(i);
	
		ModelAndView modelAndView=new ModelAndView("displayQuestions");
		req.setAttribute("questions",  tagQuestions);
		return modelAndView;
	
	}
	
	
	@RequestMapping(value = "tag_search.htm", method = RequestMethod.GET)
	// @RequestMapping(value="tags.htm")
	public ModelAndView getMatchedTag(HttpServletRequest req) {
		String tagName = req.getParameter("tagName");
		// String tagName="ja";
		List<Tag> tags = tagService.getMatchedTag(tagName);

		ModelAndView modelAndView = new ModelAndView("displayTags");
		req.setAttribute("tags", tags);
		return modelAndView;

	}

	@RequestMapping(value = "/get_tag_list.json", 
			 method = RequestMethod.GET, 
            headers="Accept=*/*")
	public  @ResponseBody List<String> getTagList(@RequestParam("term") String query) {
	System.out.println("json");
		List<String> TagsList = tagService.searchMatchedTag(query);
		System.out.println(TagsList + "in controller");
		return TagsList;
	}
	
}
