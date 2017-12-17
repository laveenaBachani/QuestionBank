/**
 * 
 */
package com.metacube.questionbank.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.questionbank.dao.QuestionDAO;
import com.metacube.questionbank.dao.TagDAO;
import com.metacube.questionbank.model.Question;
import com.metacube.questionbank.model.Tag;
import com.metacube.questionbank.service.TagService;

/**
 * @author Admin39
 *
 */
public class TagServiceImpl implements TagService {
	@Autowired
	TagDAO tagDAO;

	public List<Tag> getTags() {
		return tagDAO.getTags();
	}

	public List<Question> getTagQuestions(int tag_id) {
		return tagDAO.getTagQuestions(tag_id);
	}
		public List<Tag> getMatchedTag(String tagName) {
			// TODO Auto-generated method stub
			return tagDAO.getMatchedTag(tagName);
		}
		
		public List<String> searchMatchedTag(String query) {
	       	
	    	String technology = null;
	        query = query.toLowerCase();
	        List<String> matched = new ArrayList<String>();
	        List<Tag>  alltagslist=tagDAO.getTags();
			System.out.println(alltagslist + "in service ");
			
	        for(int i=0; i < alltagslist.size(); i++) {
	            technology = alltagslist.get(i).getTagName().toLowerCase();
	            if(technology.startsWith(query)) {
	            	matched.add(alltagslist.get(i).getTagName());
	            }
	            
	        }
	        System.out.println("matched in service" + matched);
	        return matched;
	    }
}
