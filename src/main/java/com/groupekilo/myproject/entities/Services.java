package com.groupekilo.myproject.entities;

import java.io.Serializable;

public class Services implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idS;
	private String nomS;
	private int portS;
	private String etat;
	private Serveur serveur;
	public Services() {
		super();
	}
	public Services(int idS, String nomS, int portS, String etat, Serveur serveur) {
		super();
		this.idS = idS;
		this.nomS = nomS;
		this.portS = portS;
		this.etat = etat;
		this.serveur = serveur;
	}
	public int getIdS() {
		return idS;
	}
	public void setIdS(int idS) {
		this.idS = idS;
	}
	public String getNomS() {
		return nomS;
	}
	public void setNomS(String nomS) {
		this.nomS = nomS;
	}
	public int getPortS() {
		return portS;
	}
	public void setPortS(int portS) {
		this.portS = portS;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Serveur getServeur() {
		return serveur;
	}
	public void setServeur(Serveur serveur) {
		this.serveur = serveur;
	}
	
	
	
	
}
