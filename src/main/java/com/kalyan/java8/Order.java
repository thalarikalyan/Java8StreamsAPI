package com.kalyan.java8;

import java.time.LocalDate;

public class Order {

	private int orderId;
	private String productName;
	private String customerId;
	private double price;
	private String status; // e.g., "DELIVERED", "PENDING", "CANCELLED"
	private LocalDate orderDate;
	private int quantity;

	public Order(int orderId, String productName, String customerId, double price, String status, LocalDate orderDate,
			int quantity) {
		super();
		this.orderId = orderId;
		this.productName = productName;
		this.customerId = customerId;
		this.price = price;
		this.status = status;
		this.orderDate = orderDate;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productName=" + productName + ", customerId=" + customerId + ", price="
				+ price + ", status=" + status + ", orderDate=" + orderDate + ", quantity=" + quantity + "]";
	}

}
