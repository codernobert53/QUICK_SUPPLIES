package com.quick.supplies.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.quick.supplies.domain.Admin;
import com.quick.supplies.domain.repository.AdminRepository;

@Repository
public class AdminRepositoryImpl implements AdminRepository{

	@Autowired
	 private NamedParameterJdbcTemplate jdbcTemplate;
	
	//INSERT
	@Override
	public void addPriceTrends(Admin admin) {
		String SQL = "INSERT INTO price_trends (product, location, quantity, low, high, date) VALUES (:product, :location, :quantity, :low, :high, :date)";
		 Map<String, Object> params = new HashMap<>();
		 params.put("product", admin.getProduct());
		 params.put("location", admin.getLocation());
		 params.put("quantity", admin.getQuantity());
		 params.put("low", admin.getLow());
		 params.put("high", admin.getHigh());
		 params.put("date", admin.getDate());
		 
		 jdbcTemplate.update(SQL, params);
	}
    
	@Override
	public void addOrder(Admin admin) {
		String SQL = "INSERT INTO orders_made (productId, owner,contact,product, unitPrice, weight,quantity, description) VALUES (:productId, :owner,:contact, :product, :unitPrice, :weight, :quantity, :description)";
		 
		 Map<String, Object> params = new HashMap<>();
		 
		 params.put("productId", admin.getProductId());
		 params.put("owner", admin.getOwner());
		 params.put("contact", admin.getContact());
		 params.put("product", admin.getProduct());
		 params.put("weight", admin.getWeight());
		 params.put("quantity", admin.getQuantity());
		 params.put("unitPrice", admin.getUnitPrice());
		 params.put("description", admin.getDescription());
		 
		 jdbcTemplate.update(SQL, params);
	}
	
	//Read
	@Override
	public List<Admin> getAllPriceTrends() {
		Map<String, Object> params = new HashMap<String,
				Object>();
				List<Admin> result = jdbcTemplate.query("SELECT *FROM price_trends", params, new PriceTrendsMapper());
				return result;
	}

	private static final class PriceTrendsMapper implements RowMapper<Admin> {
		 public Admin mapRow(ResultSet rs, int rowNum) 
		 throws SQLException {
		 Admin admin = new  Admin();
		 admin.setPriceTrend_id(rs.getInt("priceTrend_id"));
		 admin.setProduct(rs.getString("product"));
		 admin.setLocation(rs.getString("location"));
		 admin.setQuantity(rs.getString("quantity"));
		 admin.setLow(rs.getString("low"));
		 admin.setHigh(rs.getString("high"));
		 admin.setDate(rs.getString("date"));
		 
		 return admin;
		 }
		 }
	

	//Update
	private SqlParameterSource getSqlParameterByModel(Admin admin){
		  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		  if(admin != null){
		   parameterSource.addValue("priceTrend_id", admin.getPriceTrend_id());
		   parameterSource.addValue("product", admin.getProduct());
		   parameterSource.addValue("location", admin.getLocation());
		   parameterSource.addValue("quantity", admin.getQuantity());
		   parameterSource.addValue("low", admin.getLow());
		   parameterSource.addValue("high", admin.getHigh());
		   parameterSource.addValue("date", admin.getDate());
		   
		   parameterSource.addValue("delivery_status", admin.getDelivery_status());
		   
		  }
		  return parameterSource;
		 }
	
	@Override
	public void updatePriceTrends(Admin admin) {
		String sql = "UPDATE price_trends SET product = :product, location = :location, quantity = :quantity,low = :low , high = :high, date = :date  WHERE priceTrend_id = :priceTrend_id";
		  
		jdbcTemplate.update(sql, getSqlParameterByModel(admin));
	}
	
	
	
	//Delete
	@Override
	public void deletePriceTrends(int priceTrend_id) {
		String sql = "DELETE FROM price_trends WHERE priceTrend_id = :priceTrend_id";
		  
		jdbcTemplate.update(sql, getSqlParameterByModel(new Admin(priceTrend_id)));
	}

	@Override
	public Admin findPriceTrendsById(int priceTrend_id) {
		String sql = "SELECT * FROM price_trends WHERE priceTrend_id = :priceTrend_id";
		  
		return jdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Admin(priceTrend_id)), new PriceTrendsMapper());
	}

	

	


}
