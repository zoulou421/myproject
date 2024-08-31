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
		String sql="INSERT INTO serveur VALUES(NULL, ?, ?)";
		try {
			db=new DB();
			db.initPrepare(sql);
			db.getPreparedStatement().setString(1, serveur.getNomServ());
			db.getPreparedStatement().setString(2, serveur.getAdripServ());
			ok=db.executeMaj();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public int delete(int idServ) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Serveur serveur) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Serveur get(int idServ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Serveur> liste() {
		List<Serveur>l_serveur=new ArrayList<Serveur>();
		String sql="SELECT *FROM serveur";
		try {
			db=new DB();
			db.initPrepare(sql);
			rs= db.executeSelect();
			while(rs.next()) {
				Serveur serveur=new Serveur();
				serveur.setIdServ(rs.getInt(1));
				serveur.setNomServ(rs.getString(2));
				serveur.setAdripServ(rs.getString(3));
				l_serveur.add(serveur);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return l_serveur;
	}

}
