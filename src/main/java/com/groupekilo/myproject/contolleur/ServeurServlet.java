package com.groupekilo.myproject.contolleur;

import java.io.IOException;
import java.util.List;

import com.groupekilo.myproject.dao.IServeur;
import com.groupekilo.myproject.dao.ServeurImpl;
import com.groupekilo.myproject.entities.Serveur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="ServeurServlet", urlPatterns = {"/Serveur"})
public class ServeurServlet extends HttpServlet{
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page").toString();
		IServeur iServeurDAO=new ServeurImpl();
		
		List <Serveur>myListe=iServeurDAO.liste();
		
		if(page.equals("liste")) {
			if(myListe!=null) {
				request.setAttribute("myListe", myListe);
				request.getRequestDispatcher("/WEB-INF/serveur/liste.jsp").forward(request, response);
			}
		
		}else if(page.equals("add")){
			
		}
	}

}
