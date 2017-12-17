<%@page import="com.metacube.questionbank.model.Question"%>
<%@page import="com.metacube.questionbank.model.Answer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question-Answer</title>
</head>
<body>

	Answers Desp

	<%List<Answer> answers=(List<Answer>)request.getAttribute("answers"); 
 List<Question> question=(List<Question>)request.getAttribute("question");
 List<Integer> upvotes=(List<Integer>)request.getAttribute("upvotes");
 List<Integer> downVotes=(List<Integer>)request.getAttribute("downVotes");
 List<Answer> answerPosted=(List<Answer>)request.getAttribute("answerUser");
 List<Answer> answerLiked=(List<Answer>)request.getAttribute("answerLiked");
 for(Question q:question)	{
		
		out.println( q.getQuestionDesc());
	}
	for(Answer a:answers)	{
		
	out.println( a.getAnswerDesc());
	
}
	 for(Integer i:upvotes)	{
			
			out.println( i);
		}
	 for(Integer j:downVotes)	{
			
			out.println( j);
		}
	 %> <br/>answers posted:
	 <% 
	
	 for(Answer p:answerPosted)	{
			out.println( p.getAnswerDesc());
		}


%>
<br/>
<form action="QuestionAnswer.htm?id=<%=question.get(0).getQuesId()%>" method="POST">
<textarea name="answer" placeholder="Post your answer"></textarea>
<br/>
<input type="submit" value="submit">
</form>
</body>
</html>