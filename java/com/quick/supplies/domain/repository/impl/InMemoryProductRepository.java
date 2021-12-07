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

import com.quick.supplies.domain.Product;
import com.quick.supplies.domain.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository{

	@Autowired
	 private NamedParameterJdbcTemplate jdbcTemplate;

	//INSERT
	@Override
	public void addProduct(Product product) {
		String SQL = "INSERT INTO PRODUCTS (ID, owner,contact, product, UNIT_PRICE, location, weight,quantity, description, delivery_status) VALUES (:id, :owner, :contact, :product, :unitPrice,:location, :weight, :quantity, :description,:delivery_status)";
		 Map<String, Object> params = new HashMap<>();
		 params.put("id", product.getProductId());
		 params.put("owner", product.getOwner());
		 params.put("contact", product.getContact());
		 params.put("product", product.getProduct());
		 params.put("location", product.getLocation());
		 params.put("weight", product.getWeight());
		 params.put("quantity", product.getQuantity());
		 params.put("unitPrice", product.getUnitPrice());
		 params.put("description", product.getDescription());
		 params.put("delivery_status", product.getDelivery_status());

 
		 jdbcTemplate.update(SQL, params);
	}

	//READ
	@Override
	public List<Product> getAllProducts() {
		Map<String, Object> params = new HashMap<String,
		Object>();
		List<Product> result = jdbcTemplate.query("SELECT *FROM products", params, new ProductMapper());
		return result;
	}
	
	private static final class ProductMapper implements RowMapper<Product> {
	 public Product mapRow(ResultSet rs, int rowNum) 
	 throws SQLException {
	 Product product = new Product();
	 product.setProId(rs.getInt("proId"));
	 product.setProductId(rs.getString("ID"));
	 product.setOwner(rs.getString("owner"));
	 product.setContact(rs.getString("contact"));
	 product.setDescription(rs.getString("description"));
	 product.setUnitPrice(rs.getString("UNIT_PRICE"));
	 product.setProduct(rs.getString("product"));
	 product.setWeight(rs.getString("weight"));
	 product.setQuantity(rs.getString("quantity"));
	 product.setLocation(rs.getString("location"));
	 product.setDelivery_status(rs.getString("delivery_status"));

	 return product;
	 }
	 }

	// @Override
	// public List<Product> getProductsByCategory(String category) {
		// String SQL = "SELECT * FROM PRODUCTS WHERE CATEGORY = :category";
	    // Map<String, Object> params = new HashMap<String, Object>();
		// params.put("category", category);
		// return jdbcTemplate.query(SQL, params, new ProductMapper());
	// }


	@Override
	public Product getProductById(String productID) {
		String SQL = "SELECT * FROM PRODUCTS WHERE ID = :id";
		 Map<String, Object> params = new HashMap<String, Object>();
		 params.put("id", productID);
		 return jdbcTemplate.queryForObject(SQL, params, new ProductMapper());
	}

    //UPDATE
	private SqlParameterSource getSqlParameterByModel(Product product){
		  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		  if(product != null){
		   parameterSource.addValue("proId", product.getProId());
		   parameterSource.addValue("productId", product.getProductId());
		   parameterSource.addValue("owner", product.getOwner());
		   parameterSource.addValue("contact", product.getContact());
		   parameterSource.addValue("UNIT_PRICE", product.getUnitPrice());
		   parameterSource.addValue("description", product.getDescription());
		   parameterSource.addValue("product", product.getProduct());
		   parameterSource.addValue("location", product.getLocation());
		   parameterSource.addValue("weight", product.getWeight());
		   parameterSource.addValue("quantity", product.getQuantity());
		   parameterSource.addValue("delivery_status", product.getDelivery_status());

		  }
		  return parameterSource;
		 }
	
	
	
	@Override
	public void updateProduct(Product product) {
		String sql = "UPDATE products SET owner = :owner,contact = :contact, UNIT_PRICE = :UNIT_PRICE, description = :description,product = :product,weight = :weight, quantity = :quantity WHERE proId = :proId";
		  
		jdbcTemplate.update(sql, getSqlParameterByModel(product));
		
	}

	@Override
	public void updateDeliveryStatus(Product product) {
		String sql = "UPDATE products SET delivery_status = :delivery_status WHERE proId = :proId";
		  
		jdbcTemplate.update(sql, getSqlParameterByModel(product));
	}
    
	//DELETE
	@Override
	public void deleteProduct(int proId) {
		String sql = "DELETE FROM products WHERE proId = :proId";
		  
		jdbcTemplate.update(sql, getSqlParameterByModel(new Product(proId)));
	}
	
	
	@Override
	public Product findProduct(int proId) {
		String sql = "SELECT * FROM products WHERE proId = :proId";
		  
		return jdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Product(proId)), new ProductMapper());
	}

	
	
}
