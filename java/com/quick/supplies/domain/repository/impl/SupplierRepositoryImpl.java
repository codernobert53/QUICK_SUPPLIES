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

import com.quick.supplies.domain.Supplier;
import com.quick.supplies.domain.repository.SupplierRepository;

@Repository
public class SupplierRepositoryImpl implements SupplierRepository {

	@Autowired
	 private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public void addSupplier(Supplier supplier) {
		String SQL = "INSERT INTO suppliers (name,contact, address) VALUES (:name, :contact, :address)";
		 Map<String, Object> params = new HashMap<>();
		 params.put("name", supplier.getName());
		 params.put("contact", supplier.getContact());
		 params.put("address", supplier.getAddress());

		 jdbcTemplate.update(SQL, params);
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		Map<String, Object> params = new HashMap<String,
				Object>();
				List<Supplier> result = jdbcTemplate.query("SELECT *FROM suppliers", params, new SupplierMapper());
				return result;
	}
	
	private static final class SupplierMapper implements RowMapper<Supplier> {
		 public Supplier mapRow(ResultSet rs, int rowNum) 
		 throws SQLException {
	     Supplier supplier = new Supplier();
		 supplier.setSupplier_Id(rs.getInt("supplier_Id"));
		 supplier.setName(rs.getString("name"));
		 supplier.setContact(rs.getString("contact"));
		 supplier.setAddress(rs.getString("address"));

		 return supplier;
		 }
	}

	private SqlParameterSource getSqlParameterByModel(Supplier supplier){
		  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		  if(supplier!= null){
		   parameterSource.addValue("supplier_Id", supplier.getSupplier_Id());
		   parameterSource.addValue("name", supplier.getName());
		   parameterSource.addValue("contact", supplier.getContact());
		   parameterSource.addValue("address", supplier.getAddress());

		  }
		  return parameterSource;
		 }
	
	@Override
	public void updateSupplierDetails(Supplier supplier) {
		String sql = "UPDATE suppliers SET name = :name, contact = :contact, address = :address WHERE supplier_Id = :supplier_Id";
		  
		jdbcTemplate.update(sql, getSqlParameterByModel(supplier));
	}

	@Override
	public void deleteSupplierDetails(int supplier_Id) {
		String sql = "DELETE FROM suppliers WHERE supplier_Id = :supplier_Id";
		  
		jdbcTemplate.update(sql, getSqlParameterByModel(new Supplier(supplier_Id)));
	}

	@Override
	public Supplier findSupplierById(int supplier_Id) {
		String sql = "SELECT * FROM suppliers WHERE supplier_Id = :supplier_Id";
		  
		return jdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Supplier(supplier_Id)), new SupplierMapper());
	}
	
	
}
