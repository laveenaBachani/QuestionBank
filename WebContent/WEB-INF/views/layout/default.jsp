<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Question-Bank</title>
		<link rel="stylesheet" href="css/site.css">
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/bootstrap-theme.css">
		<link rel="stylesheet" href="css/bootstrap.css">
		<script src="js/bootstrap.js"></script>
		<script src="js/jquery-1.11.1.min.js"></script>		
	</head>
	<body>
		<header class="page-header">
			<tiles:insertAttribute name="header" />
		</header>
		
		<nav id="nav">
			<tiles:insertAttribute name="nav"/>
		</nav>
		
		<section>
			<tiles:insertAttribute name="body"/>
		</section>
		 
		 <footer>
			<tiles:insertAttribute name="footer"/>
		</footer>
	</body>
</html>