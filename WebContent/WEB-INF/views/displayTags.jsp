<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="com.metacube.questionbank.model.Tag"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" 
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript" 
		src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

	
</head>
<body>

 <div>
<!--<form action="tag_search.htm">-->
<form action="tag_search.htm">
Search Tag<input type="text" id="tagName" name="tagName">
<input type="submit" value="search">
</form>
</div>
 
 
 <script type="text/javascript">
function split(val) {
    return val.split(/,\s*/);
}
function extractLast(term) {
    return split(term).pop();
}

$(document).ready(function() {

$( "#tagName").autocomplete({
	    source: function (request, response) {
	        $.getJSON("${pageContext. request. contextPath}/get_tag_list.json", {
	            term: extractLast(request.term)
	        }, response);
	    },
	    search: function () {
	        // custom minLength
	        var term = extractLast(this.value);
	        if (term.length < 1) {
	            return false;
	        }
	    },
	    focus: function () {
	        // prevent value inserted on focus
	        return false;
	    },
	    select: function (event, ui) {
	        var terms = split(this.value);
	        // remove the current input
	        terms.pop();
	        // add the selected item
	        terms.push(ui.item.value);
	        // add placeholder to get the comma-and-space at the end
	        terms.push("");
	        this.value = terms.join(", ");
	        return false;
	    }
	});
	
});
</script>
 
<%
int i=0;
List<Tag> tags=(List<Tag>)request.getAttribute("tags");
for(Tag q:tags)
{i++;
	//out.print(q.getTagId());%>
	 <div class="container">
    <div class="row">
        <div class="col-lg-4"><a href="tag_questions.htm?id=<%=i%>"><% out.print(q.getTagName());%></a>
     
        </div>
        
	</div></div>
	<% } %>





</body>
</html>