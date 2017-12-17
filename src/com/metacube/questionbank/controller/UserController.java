package com.metacube.questionbank.controller;


import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import net.tanesha.recaptcha.ReCaptchaImpl;
//import net.tanesha.recaptcha.ReCaptchaResponse;



import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.questionbank.model.User;
import com.metacube.questionbank.service.impl.UserServiceImpl;
import com.metacube.questionbank.utility.Validator;

@Controller 
public class UserController {
	String password =""; 

	@Autowired
	UserServiceImpl userservice;
	@Autowired
	private JavaMailSenderImpl mailSender;

	@RequestMapping(value="register")
	public ModelAndView registerPerson()
	{
		return new ModelAndView("register");
	}
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public ModelAndView insertData(User user,HttpServletRequest request)
	{
		ReCaptchaImpl captcha = new ReCaptchaImpl();
		captcha.setPrivateKey("6Lel2PsSAAAAAGpmnVpRQURTVFlPXeVv4b_CUXbF");

		String challenge = request.getParameter("recaptcha_challenge_field");
		String uresponse = request.getParameter("recaptcha_response_field");
		ReCaptchaResponse reCaptchaResponse =
				captcha.checkAnswer(request.getRemoteAddr(),
						challenge, uresponse
						);


		String error="There was a problem in registering";
		if(user ==null)
		{
			return new ModelAndView("register","error",error);
		}
		else if(reCaptchaResponse.isValid())
		{
			userservice.insertUser(user);
		}
		else
		{
			return new ModelAndView("register","error",error +"invalid captacha");

		}
		return new ModelAndView("home");
	}
	@RequestMapping(value="edit")
	public ModelAndView editUserDetails(User user)
	{
		userservice.updateDetails(user);
		return new ModelAndView("viewDetails");
	}
	@RequestMapping(value="forgotpassword.htm",method=RequestMethod.GET)
	public ModelAndView forgotPasswordPage()
	{
		System.out.println("in forgotpassword get requ");
		return new ModelAndView("forgotpassword");
	}

	@RequestMapping(value="forgotpassword.htm",method=RequestMethod.POST) 
	public ModelAndView forgotpassword(HttpServletRequest request ) {
		String to_address= request.getParameter("email");

		if(password.isEmpty())
		{

			return new ModelAndView("forgotpassword").addObject("error","invalid status");
		}


		else {


			// takes input from e-mail form
			String subject="Password Recovery";



			// forwards to the view named "Result"
			mailSender.send(new MimeMessagePreparator() {
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper messageHelper = new MimeMessageHelper(
							mimeMessage, true, "UTF-8");
					messageHelper.setTo(to_address);
					messageHelper.setSubject(subject);
					messageHelper.setText(password);

				}
			});

			return new ModelAndView("Index");


		}


	}
	@RequestMapping(value="login.htm") 
	public ModelAndView loginpage()
	{
		return new ModelAndView("login");
	}
	@RequestMapping(value="loginuser.htm" ,method=RequestMethod.POST)
	public ModelAndView loginuser(User user,HttpServletRequest request,HttpSession httpSession)
	{
		
		boolean flag=false;

		if(Validator.Email(user.getEmail()) &&  Validator.checkEmpty(user.getPassword()))
		{
			User tempref=userservice.authenticate(user);
			if(tempref!=null)
			{
				System.out.println(tempref.getEmail() + "EMail in controller ");
				System.out.println(tempref.getName() + "name ");
				
				httpSession.setAttribute("user",user);
				return new ModelAndView("index","user",httpSession);
			}
			else
			{
				return new ModelAndView("login","error","unautho");
			}

		}
		else
		{
			return new ModelAndView("login");
		}
	}
}





