<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.groupekilo.myproject.entities.Serveur"%>
<%@ page import="java.util.List"%>

<!Doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700"
	rel="stylesheet">

<link rel="stylesheet" href="public/menu/fonts/icomoon/style.css">

<link rel="stylesheet" href="public/menu/css/owl.carousel.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="public/menu/css/bootstrap.min.css">

<!-- Style -->
<link rel="stylesheet" href="public/menu/css/style.css">

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.5/font/bootstrap-icons.min.css"
	rel="stylesheet">

<title>Website Menu #6</title>
</head>
<body>


	<div class="site-mobile-menu site-navbar-target">
		<div class="site-mobile-menu-header">
			<div class="site-mobile-menu-close mt-3">
				<span class="icon-close2 js-menu-toggle"></span>
			</div>
		</div>
		<div class="site-mobile-menu-body"></div>
	</div>



	<header class="site-navbar site-navbar-target py-4" role="banner">

		<div class="container">
			<div class="row align-items-center position-relative">

				<div class="col-3 ml-auto text-right order-2">
					<div class="site-logo">
						<a href="index.html" class="font-weight-bold text-white">HOME</a>
					</div>
				</div>

				<div class="col-9 order-1 text-left mr-auto">


					<span class="d-inline-block d-lg-block"><a href="#"
						class="text-black site-menu-toggle js-menu-toggle py-5"><span
							class="icon-menu h3 text-white"></span></a></span>



					<nav class="site-navigation text-right ml-auto d-none d-lg-none"
						role="navigation">
						<ul class="site-menu main-menu js-clone-nav ml-auto ">
							<li class="active"><a href="index.html" class="nav-link">Home</a></li>
							<li><a href="serveur?page=liste" class="nav-link">Liste
									Serveurs</a></li>
							<li><a href="serveur?page=add" class="nav-link">Ajout
									Serveur</a></li>
							<li><a href="services?page=liste" class="nav-link">Liste
									Services</a></li>
							<li><a href="services?page=add" class="nav-link">Ajout
									Service</a></li>
						</ul>
					</nav>
				</div>


			</div>
		</div>

	</header>

	<div class="hero"
		style="background-image: url('public/menu/images/hero_1.jpg'); background-size: 100%;">


		<div class="container">
			<h1 style="color: green; font-weight: bold;">Liste des Serveurs</h1>
			<br />
			<h3>Infos provenant de la base de données des serveurs</h3>
			<table class="table table-bordered border-dark  table-striped">
				<thead>
					<tr>
						<th width="10%">ID Serveurs</th>
						<th width="30%">Nom Serveurs</th>
						<th width="70%">Adresse IP Serveurs</th>
						<th width="5%">Action</th>
					</tr>
				</thead>
				<tbody>

					<%
					// Retrieve the list from the request object
					List<Serveur> litems_ = (List<Serveur>) request.getAttribute("myListe");

					// Check if the list is not null and iterate over it
					if (litems_ != null) {
						for (Serveur serveur : litems_) {
					%>
					<tr>
						<td style="color: white;"><%=serveur.getIdServ()%></td>
						<td style="color: white;"><%=serveur.getNomServ()%></td>
						<td style="color: white;"><%=serveur.getAdripServ()%></td>
						<td><a href="serveur?page=delete&id=<%=serveur.getIdServ()%>"
							class="btn btn-danger"> <i class="bi bi-trash btn-sm"></i>
								Delete
						</a></td>
						<td>
							<!-- Edit link --> <a
							href="<%=request.getContextPath()%>/serveur?page=edit&id=<%=serveur.getIdServ()%>"
							class="btn btn-warning"> <i class="bi bi-pencil"></i> Edit
						</a>
						</td>
						<%
						}
						} else {
						%>



						<td>No items found.</td>
						<td>No items found.</td>
						<td>No items found.</td>
					</tr>
					<%
					}
					%>


				</tbody>
			</table>
		</div>



	</div>



	<script src="public/menu/js/jquery-3.3.1.min.js"></script>
	<script src="public/menu/js/popper.min.js"></script>
	<script src="public/menu/js/bootstrap.min.js"></script>
	<script src="public/menu/js/jquery.sticky.js"></script>
	<script src="public/menu/js/main.js"></script>
</body>
</html>