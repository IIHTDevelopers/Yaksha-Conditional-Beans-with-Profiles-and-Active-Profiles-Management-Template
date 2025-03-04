package com.yaksha.assignment.models;

public class Order {

	private String orderId;
	private double totalAmount;
	private Product product;

	// Constructor
	public Order(String orderId, double totalAmount, Product product) {
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.product = product;
	}

	// Getters and Setters
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", totalAmount=" + totalAmount + ", product=" + product + "]";
	}
}
