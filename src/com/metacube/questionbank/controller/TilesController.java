/**
 * 
 */
package com.metacube.questionbank.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.questionbank.model.User;

/**
 * @author Admin39
 *
 */
@Controller
public class TilesController {

	@RequestMapping(value="index")
	public String index() {
		System.out.println("aj");
		System.out.println("Rajeev");
		return "index";
	}
	
	@RequestMapping(value="viewPerson")
	public ModelAndView viewPerson() {
		return new ModelAndView("personList");
	}
}
