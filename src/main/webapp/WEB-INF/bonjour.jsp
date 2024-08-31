<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="java.util.List" %>
<html>

<head>
<meta charset="UTF-8" />
<title>Welcome</title>
</head>

  <body>
    <ul>
        <%
            // Retrieve the list from the request object
            List<String> items = (List<String>) request.getAttribute("liste");

            // Check if the list is not null and iterate over it
            if (items != null) {
                for (int i = 0; i < items.size(); i++) {
                	String item = items.get(i);
        %>
                    <li><%= item %></li>
        <%
                }
            } else {
        %>
            <li>No items found.</li>
        <%
            }
        %>
    </ul>
    
  
  
  
        <h1>Bienvenue avec JSTL</h1>
     
      <h2>List of Items</h2>
    <ul>
        <!-- Iterate over the list using JSTL -->
        <c:forEach var="item" items="${liste}">
            <li>${item}</li>
        </c:forEach>
        
        <!-- If the list is empty or null -->
        <c:if test="${empty items}">
            <li>No items found.</li>
        </c:if>
    </ul>
  </body>
</html>