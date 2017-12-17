<%@page import="com.metacube.questionbank.model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>User Account</title>
		<link rel="stylesheet" href="css/style.css" type="text/css">
		<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
		<script type="text/javascript" src="js/activateTabs.js"></script>
		
	</head>
	<body>
	<%
	User u=(User)session.getAttribute("user");
	System.out.print(u.getPassword());
	%>
		<div class="container">
			<section class="register">
				<h1>Register on MetaCube</h1>
				<div id = "loginAndregister" class = "clearfix">
					<ul>
						<li id = "newUser">Register</li>
						<li id = "exitingUser">Login</li>
					</ul>
				</div>
				<form action="UserAccountServlet" name="registrationForm" id="registrationForm" method="post">
					<div class = "dvErrorMain" id = "error">${error}</div>
					<div class="regSection personalInfo">
      					<h3>Your Personal Information</h3>
      					<input type="text" name="username" value="" placeholder="Your Name">
      					<div class = "dvError" id = "nameError">${nameError}</div>
      					<input type="text" name="email" value="" placeholder="Your E-mail Address">
      					<div class = "dvError" id = "emailError">${emailError}</div>
      				</div>
     				<div class="regSection password">
      					<h3>Your Password</h3>
      					<input type="password" name="password" value="" placeholder="Your Password">
      					<div class = "dvError" id = "passwordError">${passwordError}</div>
      					<input type="password" name="confirm" value="" placeholder="Confirm Password">
      					<div class = "dvError" id = "confirmPasswordError">${confirmPasswordError}</div>
      				</div>
      				<p class="terms">
	        			<label>
	          				<input type="checkbox" name="accept" id="accept">
	           				I accept  <a href="#">MetaCube</a> Terms & Condition.
	        			</label>
      				</p>
      				<p class="submit">
      					<input type="submit" id = "signUp" name="submit" value="Sign Up">
      				</p>				
				</form>
				<form action="UserLoginServlet" name="loginForm" id = "loginForm" method="post">
					<div class = "dvErrorMain" id = "error">${error}</div>
					<div class="regSection personalInfo">
      					<h3>E-Mail</h3>      					
      					<input type="text" name="email" value="" placeholder="Your E-mail Address">      					
      				</div>
     				<div class="regSection password">
      					<h3>Password</h3>
      					<input type="password" name="password" value="" placeholder="Your Password">      					
      				</div>
      				<p class="terms" style="font-size: 12px;">          				
	           				<a href="#">Forget password</a>
      				</p>  				
      				<p class="submit">
      					<input type="submit" name="submit" value="Sign In">
      				</p>				
				</form>
			</section>
		</div>
	</body>
</html>