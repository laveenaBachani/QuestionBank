/**
 * 
 */
package com.metacube.questionbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.questionbank.dao.UserDAO;
import com.metacube.questionbank.model.User;
import com.metacube.questionbank.service.UserService;
import com.metacube.questionbank.utility.MailSending;



/**
 * @author Admin39
 *
 */
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userdao;
	public void insertUser(User user) {
		userdao.insertUser(user);
	}
	public void updateDetails(User user) {
		userdao.updateData(user);
	}
	public void forgotPasswordmail(String toaddress,String subject,String message)
	{
		MailSending mailSending=new MailSending();
		mailSending.sendMail( toaddress, subject, message);
	}
	public User IsValidUser(String email,String password)
	{
		return userdao.isValidUser(email,password);
	}
	public User authenticate(User user) {
        	return userdao.authenticate(user);
		
	}
	
}
