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

import com.quick.supplies.domain.OrdersMade;
import com.quick.supplies.domain.repository.OrdersMadeRepository;

@Repository
public class OrdersMadeRepositoryImpl implements OrdersMadeRepository {

	@Autowired
	 private NamedParameterJdbcTemplate jdbcTemplate;
	
	//READ
	@Override
	public List<OrdersMade> getAllOrdersMade() {
		Map<String, Object> params = new HashMap<String,
				Object>();
				List<OrdersMade> result = jdbcTemplate.query("SELECT *FROM orders_made", params, new OrdersMadeMapper());
				return result;
	}
	
	@Override
	public List<OrdersMade> countAllOrders() {
		Map<String, Object> params = new HashMap<String,
				Object>();
				List<OrdersMade> result = jdbcTemplate.query("SELECT COUNT(*) AS NumberOfOrders FROM orders_made", params, new OrdersMadeMapper());
				return result;
	}
	
	@Override
	public List<OrdersMade> getAllDeliveredOrders() {
		Map<String, Object> params = new HashMap<String,
				Object>();
				List<OrdersMade> result = jdbcTemplate.query("SELECT *FROM orders_made WHERE delivery_status='DELIVERED'", params, new OrdersMadeMapper());
				return result;
	}

	private static final class OrdersMadeMapper implements RowMapper<OrdersMade> {
		 public OrdersMade mapRow(ResultSet rs, int rowNum)
		 throws SQLException {
		 OrdersMade ordersMade = new OrdersMade();
		 ordersMade.setOrderId(rs.getInt("orderId"));
		 ordersMade.setProductId(rs.getString("productId"));
		 ordersMade.setOwner(rs.getString("owner"));
		 ordersMade.setContact(rs.getString("contact"));
		 ordersMade.setProduct(rs.getString("product"));
		 ordersMade.setWeight(rs.getString("weight"));
		 ordersMade.setQuantity(rs.getString("quantity"));
		 ordersMade.setUnitPrice(rs.getString("unitPrice"));
		 ordersMade.setDescription(rs.getString("description"));
		 ordersMade.setDelivery_status(rs.getString("delivery_status"));
		
		 return ordersMade;
		 }
	}

	private SqlParameterSource getSqlParameterByModel(OrdersMade ordersMade){
		  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		  if(ordersMade != null){
		   parameterSource.addValue("orderId", ordersMade.getOrderId());
		  }
		  return parameterSource;
		 }


	@Override
	public OrdersMade findOrdersById(int orderId) {
		String sql = "SELECT * FROM orders_made WHERE orderId = :orderId";
		  
		return jdbcTemplate.queryForObject(sql, getSqlParameterByModel(new OrdersMade(orderId)), new OrdersMadeMapper());
	}


	@Override
	public void deleteOrder(int orderId) {
		String sql = "DELETE FROM orders_made WHERE orderId = :orderId";
		  
		jdbcTemplate.update(sql, getSqlParameterByModel(new OrdersMade(orderId)));
	}

	@Override
	public OrdersMade getOrderById(String productId) {
		String SQL = "SELECT * FROM orders_made WHERE productId = :productId";
		 Map<String, Object> params = new HashMap<String, Object>();
		 params.put("productId", productId);
		 return jdbcTemplate.queryForObject(SQL, params, new OrdersMadeMapper());
	}

}
