package com.quick.supplies.domain.repository.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.quick.supplies.domain.User;
import com.quick.supplies.domain.repository.UserDao;

@Repository
public class UserDaoImpl implements UserDao{

	private JdbcTemplate jdbcTemplate;

	public UserDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}
	
	@Override
	public String loginUser(User user) {
		
            String sql = "SELECT email FROM farmer_registration WHERE email=? AND password=?";
		
		try {

			String email = jdbcTemplate.queryForObject(sql, new Object[] {
					user.getEmail(), user.getPassword() }, String.class);
             
			return email;
			
		} catch (Exception e) {
			return null;
		}

	}
	
}
