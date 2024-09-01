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
			<h1 style="color: green; font-weight: bold;">Formulaire d'ajout
				des Serveurs</h1>
			<br />
			<h3>Ajoutez les serveurs dans votre base de données</h3>
			<h1>
				<%
				// Retrieve the attribute from the request object and convert it to a String
				String verifAjout = (String) request.getAttribute("verif_ajout");

				// Check if the attribute is not null and is not empty before parsing
				if (verifAjout != null && !verifAjout.isEmpty()) {
					try {
						int message = Integer.parseInt(verifAjout);
						if (message == 0) {
					out.print("Ajout bien effectué");
						} else {
					out.print("Erreur lors de l'ajout");
						}
					} catch (NumberFormatException e) {
						out.print("Format de nombre invalide");
					}
				} else {
					out.print("Aucune information de vérification disponible");
				}
				%>
			</h1>
			<!-- >form class="form" method="post" action="serveur">
				<div class="mb-3">
					<label for="exampleInputText1" class="form-label"><b>Nom
							du Serveur</b></label> <input type="text" class="form-control"
						id="exampleInputText1" aria-describedby="textHelp" name="nomserv">
					<div id="textHelp" class="form-text">Cette information ne
						sera pas partagée.</div>
				</div>
				<div class="mb-3">
					<label for="exampleInputText1" class="form-label"><b>Adresse
							IP du Serveur</b></label> <input type="text" class="form-control"
						name="adripserv" id="exampleInputText1">
				</div>
				<input type="submit" class="btn btn-success" name="valider"
					value="Ajouter" /> <input type="reset" class="btn btn-warning"
					name="annuler" value="Nettoyer">
			</form-->
			
			 <div class="container mt-5">
        <h2>Add New Server</h2>
        <form class="form" method="post" action="serveur">
            <!-- Hidden input to specify the action (add) -->
            <input type="hidden" name="action" value="add">
            
            <!-- Server Name Input -->
            <div class="mb-3">
                <label for="serverName" class="form-label"><b>Nom du Serveur</b></label>
                <input type="text" class="form-control" id="serverName" name="nomserv" required>
                <div id="nameHelp" class="form-text">Cette information ne sera pas partagée.</div>
            </div>
            
            <!-- Server IP Address Input -->
            <div class="mb-3">
                <label for="serverIp" class="form-label"><b>Adresse IP du Serveur</b></label>
                <input type="text" class="form-control" id="serverIp" name="adripserv" required>
            </div>
            
            <!-- Submit and Reset Buttons -->
            <button type="submit" class="btn btn-success">Add Server</button>
            <a href="<%= request.getContextPath() %>/serveur?page=liste" class="btn btn-warning">Cancel</a>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
		</div>



	</div>



	<script src="public/menu/js/jquery-3.3.1.min.js"></script>
	<script src="public/menu/js/popper.min.js"></script>
	<script src="public/menu/js/bootstrap.min.js"></script>
	<script src="public/menu/js/jquery.sticky.js"></script>
	<script src="public/menu/js/main.js"></script>
</body>
</html>