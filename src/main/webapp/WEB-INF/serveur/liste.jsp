<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.groupekilo.myproject.entities.Serveur"%>
 <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
 

<div class="container-fluid mt-3">
  <h3>Navbar With Dropdown</h3>
  <p>This example adds a dropdown menu in the navbar.</p>
</div>
 
<div class="container mt-3">
  <h2>Hoverable Dark Table</h2>
  <p>The .table-hover class adds a hover effect (grey background color) on table rows:</p>            
  <table class="table table-dark table-hover">
    <thead>
      <tr>
        <th>ID</th>
        <th>Nom du Serveur</th>
        <th>Adresse IP</th>
      </tr>
    </thead>
    <tbody>
      <tr>
      
        <%
            // Retrieve the list from the request object
            
            List<Serveur> items_ = (List <Serveur>) request.getAttribute("myListe");

            // Check if the list is not null and iterate over it
            if (items_ != null) {
            	
                for (Serveur serveur:items_) {
                   
        %>
                    <td><%= serveur.getIdServ() %> </td>
                    <td><%= serveur.getNomServ() %> </td>
                    <td><%= serveur.getAdripServ() %> </td>
        <%
                }
            } else {
        %>
           
       
       
        <td>No items found.</td>
        <td>No items found.</td>
        <td>No items found.</td>
        <%
            }
        %>
       
      </tr>
    </tbody>
  </table>
</div>

</body>
</html>