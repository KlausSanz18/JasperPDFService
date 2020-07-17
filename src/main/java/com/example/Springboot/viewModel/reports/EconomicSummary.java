package com.example.Springboot.viewModel.reports;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EconomicSummary {

	private String location;
	private String code;
	private Date startDate;
	private String description;
	private double quantity;
	private double price;
	private double subtotal;
	private double tax;
	private double total;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	
	public EconomicSummary() {
		
	}

	public String getStartDate() {
		return formatter.format(startDate);
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
