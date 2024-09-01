package com.groupekilo.myproject.web;

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

@WebServlet(name="ServeurServlet", urlPatterns = {"/serveur"})
public class ServeurServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private  ServeurImpl serveur_dao;
	@Override
	public void init() throws ServletException {
		serveur_dao=new ServeurImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*if(req.getParameter("page")!=null) {
			String p=req.getParameter("page").toString();
			if(p.equals("liste")) {
				List<Serveur>l_serveurs=serveur_dao.liste();
				if(l_serveurs!=null) {
					System.out.println("Liste non vide!");
					req.setAttribute("serveurs", l_serveurs);
					req.getRequestDispatcher("/WEB-INF/serveur/liste.jsp").forward(req, resp);
				}else {
				
					System.out.println("Oops cette liste est vide!");
				}
				
			}else if(p.equals("add")) {
				req.getRequestDispatcher("/WEB-INF/serveur/add.jsp").forward(req, resp);
			}
			
		}*/
		String page=req.getParameter("page").toString();
		//IServeur iServeurDAO=new ServeurImpl();
		
		
		List <Serveur>myListe=serveur_dao.liste();
		
		if(page.equals("liste")) {
			if(myListe!=null) {
				req.setAttribute("myListe", myListe);
				req.getRequestDispatcher("/WEB-INF/serveur/liste.jsp").forward(req, resp);
			}
		
		}else if(page.equals("add")){
			req.getRequestDispatcher("/WEB-INF/serveur/add.jsp").forward(req, resp);
		}//debut
		else if (page.equals("delete")) {
	        String idParam = req.getParameter("id");
	        if (idParam != null) {
	            try {
	                int id = Integer.parseInt(idParam);
	                int ok = serveur_dao.delete(id);
	                if (ok==1) {
	                    resp.sendRedirect(req.getContextPath() + "/serveur?page=liste");
	                } else {
	                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to delete server");
	                }
	            } catch (NumberFormatException e) {
	                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
	            }
	        } else {
	            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID parameter is missing");
	        }
	    } //debut edit
		else if ("edit".equals(page)) {
	        String idParam = req.getParameter("id");
	        if (idParam != null) {
	            try {
	                int id = Integer.parseInt(idParam);
	                Serveur serveur = serveur_dao.get(id);
	                if (serveur != null) {
	                    req.setAttribute("serveur", serveur);
	                    req.getRequestDispatcher("/WEB-INF/serveur/edit.jsp").forward(req, resp);
	                } else {
	                    resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Server not found");
	                }
	            } catch (NumberFormatException e) {
	                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
	            }
	        } else {
	            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID parameter is missing");
	        }
	    }else {
	        resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Page not found");
	    }
		//fin edit	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//String nomserv=req.getParameter("nomserv").toString();
		//resp.getWriter().print(nomserv);
		/*the bellow is actually but only for adding data
		if(req.getParameter("valider")!=null) {
			String nomserv=req.getParameter("nomserv").toString();
			String adripserv=req.getParameter("adripserv").toString();
			resp.getWriter().print(nomserv);
			resp.getWriter().print(adripserv);
			
			Serveur s=new Serveur();
			s.setNomServ(nomserv);
			s.setAdripServ(adripserv);
			int ok=serveur_dao.add(s);//0 [if success] ou 1[if not success]
			req.setAttribute("verif_ajout", ok);
			if(ok==1) {
				req.getRequestDispatcher("/WEB-INF/serveur/liste.jsp");
				resp.getWriter().print("Success ajout serveur");
			}else if(ok==0) {
				resp.getWriter().print("Echec ajout serveur");
				req.getRequestDispatcher("/WEB-INF/serveur/add.jsp");
			}
		}*/
		// Get the action parameter to determine which operation to perform
	    String action = req.getParameter("action");
	 // Handle the "add" operation
	    if ("add".equals(action)) {
	        // Retrieve parameters from the request
	        String nomserv = req.getParameter("nomserv");
	        String adripserv = req.getParameter("adripserv");
	        
	        if (nomserv != null && adripserv != null) {
	            // Create a new Serveur object and set its properties
	            Serveur serveur = new Serveur();
	            serveur.setNomServ(nomserv);
	            serveur.setAdripServ(adripserv);
	            
	            // Attempt to add the new server to the database
	            int ok = serveur_dao.add(serveur); // Assuming 0 means success and 1 means failure
	            if (ok == 1) {
	                // Redirect to the list page on success
	                resp.sendRedirect(req.getContextPath() + "/serveur?page=liste");
	            } else {
	                // Forward to the add form with an error message on failure
	                req.setAttribute("error", "Echec ajout serveur");
	                req.getRequestDispatcher("/WEB-INF/serveur/add.jsp").forward(req, resp);
	            }
	        } else {
	            // Handle missing parameters
	            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters");
	        }
	    }
	    
	 // Handle the "edit" operation
	    else if ("edit".equals(action)) {
	        // Retrieve parameters from the request
	        String idParam = req.getParameter("id");
	        String nomserv = req.getParameter("nomserv");
	        String adripserv = req.getParameter("adripserv");
	        
	        if (idParam != null && nomserv != null && adripserv != null) {
	            try {
	                int id = Integer.parseInt(idParam);
	                // Create a Serveur object and set its properties
	                Serveur serveur = new Serveur();
	                serveur.setIdServ(id);
	                serveur.setNomServ(nomserv);
	                serveur.setAdripServ(adripserv);
	                
	                // Attempt to update the server in the database
	                int ok = serveur_dao.update(serveur); // Assuming 1 means success and 0 means failure
	                req.setAttribute("messageEdit", ok);
	                if (ok == 1) {
	                    // Redirect to the list page on success
	                    resp.sendRedirect(req.getContextPath() + "/serveur?page=liste");
	                } else {
	                    // Forward to the edit form with an error message on failure
	                    req.setAttribute("error", "Echec mise à jour serveur");
	                    req.getRequestDispatcher("/WEB-INF/serveur/edit.jsp").forward(req, resp);
	                }
	            } catch (NumberFormatException e) {
	                // Handle invalid ID format
	                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
	            }
	        } else {
	            // Handle missing parameters
	            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters");
	        }
	    }
	    
	    // Handle unknown actions
	    else {
	        resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Action not found");
	    }
	}
	    


}
