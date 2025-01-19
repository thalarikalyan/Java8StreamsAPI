package com.kalyan.java8;

import java.time.LocalDate;
import java.util.List;

public class Orders {

	private int id;
	private Customer customer;
	private List<Products> products;
	private String status; // e.g., "Pending", "Shipped", "Delivered"
	private LocalDate orderDate;
	private LocalDate deliveryDate;

	@Override
	public String toString() {
		return "Orders [id=" + id + ", customer=" + customer + ", products=" + products + ", status=" + status
				+ ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate + "]";
	}

	public Orders(int id, Customer customer, List<Products> products, String status, LocalDate orderDate,
			LocalDate deliveryDate) {
		super();
		this.id = id;
		this.customer = customer;
		this.products = products;
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
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

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

}
