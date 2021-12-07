package com.quick.supplies.domain.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.quick.supplies.domain.Farmer;
import com.quick.supplies.domain.repository.FarmerRepository;



@Repository
public class FarmerRepositoryImpl implements FarmerRepository{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	//CREATE
	@Override
	public void registerFarmer(Farmer farmer) {
		String SQL = "INSERT INTO farmer_registration(farmerID, name, email, password) VALUES (:farmerID, :name, :email, :password)";
		 Map<String, Object> params = new HashMap<>();
		 params.put("farmerID", farmer.getFarmerID());
		 params.put("name", farmer.getName());
		 params.put("email", farmer.getEmail());
		 params.put("password", farmer.getPassword());
		 
		 jdbcTemplate.update(SQL, params);
	}
	
}
