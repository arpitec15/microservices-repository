package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Orders {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name="order_id")
	private Integer orderId;
	
	@Column(name="order_amount")
	private Double orderAmount;
	
	@Column(name="order_date")
	private Date orderDate;
	
	

	public Orders(Integer userId, Integer orderId, Double orderAmount, Date orderDate) {
		super();
		this.userId = userId;
		this.orderId = orderId;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Orders [userId=" + userId + ", orderId=" + orderId + ", orderAmount=" + orderAmount + ", orderDate="
				+ orderDate + "]";
	}
	
   
}
