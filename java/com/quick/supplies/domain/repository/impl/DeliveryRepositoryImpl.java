package com.quick.supplies.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.quick.supplies.domain.Delivery;
import com.quick.supplies.domain.repository.DeliveryRepository;


@Repository
public class DeliveryRepositoryImpl implements DeliveryRepository{
	private JdbcTemplate jdbcTemplate;

	public DeliveryRepositoryImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	@Override
	public List<Delivery> findOrderById(int orderId) {
		List<Delivery> deliveriesList = jdbcTemplate.query("SELECT * FROM orders_made where orderId=?",
				new Object[] { orderId }, new RowMapper<Delivery>() {

					@Override
					public Delivery mapRow(ResultSet rs, int rowNum) throws SQLException {
						Delivery delivery = new Delivery();

						delivery.setOrderId(rs.getInt("orderId"));
						delivery.setProductId(rs.getString("productId"));
						delivery.setOwner(rs.getString("owner"));
						delivery.setDelivery_status(rs.getString("delivery_status"));
			

						return delivery;
					}

				});

		return deliveriesList;
	}

	@Override
	public int update(Delivery delivery) {
		String sql = "update  orders_made set delivery_status=? where orderId=?";

		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] {delivery.getDelivery_status(), delivery.getOrderId() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Delivery> read() {
		List<Delivery> deliveryList = jdbcTemplate.query("SELECT * FROM orders_made", new RowMapper<Delivery>() {

			@Override
			public Delivery mapRow(ResultSet rs, int rowNum) throws SQLException {
				Delivery delivery = new Delivery();

				delivery.setOrderId(rs.getInt("orderId"));
				delivery.setOwner(rs.getString("owner"));
				delivery.setProductId(rs.getString("productId"));
				delivery.setDelivery_status(rs.getString("delivery_status"));

				return delivery;
			}

		});

		return deliveryList;
	}
	
	
	
}
