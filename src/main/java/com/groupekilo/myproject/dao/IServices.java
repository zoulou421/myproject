package com.groupekilo.myproject.dao;

import java.util.List;

import com.groupekilo.myproject.entities.Serveur;
import com.groupekilo.myproject.entities.Services;

public interface IServices {
  public int add(Services service);
  public int delete(int idS);
  public Services get(int idS);
  public int update(Services service);
  public List<Services>liste();
  public List<Services>servicesByServeur(int idServeur);
	
}
