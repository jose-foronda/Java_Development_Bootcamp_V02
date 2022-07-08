<%@page import="com.protalento.entities.WebTextSearch"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/stylesSearchAnswer.css">
</head>
<body>
	<%
		WebTextSearch webSearch = (WebTextSearch) request.getAttribute("webSearch");
	%>
	<h1> The word "<span id="searchedText" ><%=webSearch.getText()%></span>" is found <span id="coincidences"> </span> times in the URL
	"<span id="searchedURL"> <%=webSearch.getUrl()%> </span>"</h1>


	<a href=<%=webSearch.getUrl()%>>go the site</a>
	<a href="index.html">Home</a>


	<section id="hiddenText" hidden="true" style="color:transparent;"><%=webSearch.getHtmlContent()%></section>
	<!-- <section id="hiddenText2" hidden="false"></section> --> 
	<script src="scripts/script1.js"></script>
</body>
</html>