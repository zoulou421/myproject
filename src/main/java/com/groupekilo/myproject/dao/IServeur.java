package com.groupekilo.myproject.dao;

import java.util.List;

import com.groupekilo.myproject.entities.Serveur;

public interface IServeur {
  public int add(Serveur serveur);
  public int delete(int idServ);
  public int update(Serveur serveur);
  public Serveur get(int idServ);
  public List<Serveur>liste();
}
