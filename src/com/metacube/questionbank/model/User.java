/**
 * 
 */
package com.metacube.questionbank.model;

import java.sql.Date;

/**
 * @author Admin39
 *
 */
public class User {
int user_id;
String email;
String name;
String gender;
/**
 * @return the gender
 */
public String getGender() {
	return gender;
}
/**
 * @param gender the gender to set
 */
public void setGender(String gender) {
	this.gender = gender;
}
String password;
Date dob;
String  about_me;
int rating;
int status;
/**
 * @return the user_id
 */
public int getUser_id() {
	return user_id;
}
/**
 * @param user_id the user_id to set
 */
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the password
 */
public String getPassword() {
	return password;
}
/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}
/**
 * @return the dob
 */
public Date getDob() {
	return dob;
}
/**
 * @param dob the dob to set
 */
public void setDob(Date dob) {
	this.dob = dob;
}
/**
 * @return the about_me
 */
public String getAbout_me() {
	return about_me;
}
/**
 * @param about_me the about_me to set
 */
public void setAbout_me(String about_me) {
	this.about_me = about_me;
}
/**
 * @return the rating
 */
public int getRating() {
	return rating;
}
/**
 * @param rating the rating to set
 */
public void setRating(int rating) {
	this.rating = rating;
}
/**
 * @return the status
 */
public int getStatus() {
	return status;
}
/**
 * @param status the status to set
 */
public void setStatus(int status) {
	this.status = status;
}

}
