package com.groupekilo.myproject.dao;

import java.sql.ResultSet;
import java.util.List;

import com.groupekilo.myproject.entities.Services;

public class ServicesImpl implements IServices{
 private DB db;
 private int ok;
 private ResultSet rs;
@Override
public int add(Services service) {
	
	return 0;
}
@Override
public int delete(int idS) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public Services get(int idS) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public int update(Services service) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public List<Services> liste() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public List<Services> servicesByServeur(int idServeur) {
	// TODO Auto-generated method stub
	return null;
}
}
