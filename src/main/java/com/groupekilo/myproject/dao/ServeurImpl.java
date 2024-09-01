package com.groupekilo.myproject.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.groupekilo.myproject.entities.Serveur;

public class ServeurImpl implements IServeur{
    private DB db;
    private int ok;
    private ResultSet rs;
	@Override
	public int add(Serveur serveur) {
		ok=0;
		String sql="INSERT INTO serveur VALUES(NULL,?,?)";
		try {
			db=new DB();
			//initialisation de la requete sql
			db.initPrepare(sql);
			//passage de la valeur à la requête sql
			db.getPreparedStatement().setString(1, serveur.getNomServ());
			db.getPreparedStatement().setString(2, serveur.getAdripServ());
		    //execution
			ok=db.executeMaj();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ok;
	}

	@Override
	public int delete(int idServ) {
		ok=0;
		String sql="DELETE FROM serveur WHERE idServ= ?";
		try {
			db=new DB();
			db.initPrepare(sql);
			db.getPreparedStatement().setInt(1, idServ);
			ok=db.executeMaj();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public Serveur get(int idServ) {
	    Serveur serveur = null; // Initialize serveur to null
	    String sql = "SELECT * FROM serveur WHERE idServ = ?";
	    try {
	        // Create and initialize database connection
	        db = new DB();
	        db.initPrepare(sql);
	        db.getPreparedStatement().setInt(1, idServ);
	        rs = db.executeSelect();

	        // Check if the ResultSet contains any rows
	        if (rs.next()) {
	            serveur = new Serveur(); // Instantiate serveur if a row is found
	            serveur.setIdServ(rs.getInt("idServ"));
	            serveur.setNomServ(rs.getString("nomServ"));
	            serveur.setAdripServ(rs.getString("adripServ"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return serveur;
	}

	
	
	
	@Override
	public int update(Serveur serveur) {
		ok=0;
		String sql="UPDATE serveur SET nomServ= ?, adripServ= ? WHERE idServ= ?";
		try {
			db=new DB();
			db.initPrepare(sql);
			db.getPreparedStatement().setString(1, serveur.getNomServ());
			db.getPreparedStatement().setString(2, serveur.getAdripServ());
			db.getPreparedStatement().setInt(3, serveur.getIdServ());
			ok=db.executeMaj();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public List<Serveur> liste() {
        List<Serveur>l_serveurs=new ArrayList<Serveur>();
        String sql="SELECT *FROM serveur";
        try {
        	db=new DB();
        	db.initPrepare(sql);
        	rs=db.executeSelect();
        	while(rs.next()) {
        		Serveur s=new Serveur();
        		s.setIdServ(rs.getInt(1));
        		s.setNomServ(rs.getString(2));
        		s.setAdripServ(rs.getString(3));
        		l_serveurs.add(s);
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        }
		return l_serveurs;
	}

}
