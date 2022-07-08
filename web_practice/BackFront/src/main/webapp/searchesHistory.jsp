<%@page import="com.protalento.utilities.LocalDateUtillities"%>
<%@page import="com.protalento.jdbc.implementations.WebTextSearchImp"%>
<%@page import="com.protalento.entities.WebTextSearch"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/table.css">
<link rel="stylesheet" href="styles/styles1.css" >
<link rel="stylesheet" href="styles/button.css">
</head>
<body>
    <%
    WebTextSearchImp webTextSearchImp = new WebTextSearchImp();
    List<WebTextSearch> webSearchList = (List<WebTextSearch>) webTextSearchImp.listElements();
    %>
    <nav>
        <button id="homeSearchContainer" class="button"> 
            <a id="homeSearch" class="button" href="index.html">Home</a> 
        </button>
    </nav>
    <section>
        <h2>Search History</h2>  
        <table>
            <thead>
                <tr>
                    <th>Text</th>
                    <th>URL</th> 
                    <th>Date</th> 
                </tr>
            </thead>
            <tbody>
            <% 
            	for(WebTextSearch webSearch : webSearchList){
            %>
                <tr>
                    <td><%=webSearch.getText()%></td>
                    <%String searchURL = webSearch.getUrl();%>
                    <td>
                        <a id="searchLink" href="<%=searchURL%>"> <%=searchURL%> </a>
                    </td> 
                    <td><%=LocalDateUtillities.getLocalDateTimeString(webSearch.getDate(), LocalDateUtillities.SQL_DATETIME_PATTERN)%></td>
                </tr> 
             <%
             	}
             %>
            </tbody>
        </table>
    </section>

</body>
</html>