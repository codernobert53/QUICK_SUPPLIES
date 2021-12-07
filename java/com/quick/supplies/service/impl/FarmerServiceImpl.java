package com.quick.supplies.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quick.supplies.domain.Farmer;
import com.quick.supplies.domain.repository.FarmerRepository;
import com.quick.supplies.service.FarmerService;


@Service
public class FarmerServiceImpl implements FarmerService{

	@Autowired
	 private FarmerRepository farmerRepository;
	
	@Override
	public void registerFarmer(Farmer farmer) {
		farmerRepository.registerFarmer(farmer);
	}

	
	
}
