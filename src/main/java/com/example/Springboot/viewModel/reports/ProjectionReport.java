package com.example.Springboot.viewModel.reports;

public class ProjectionReport {

	private String description;
	private double hiredPrice;
	private double hiredCount;
	private double hiredValue;
	private double previousCount;
	private double previousValue;
	private double actualCount;
	private double actualValue;
	private double totalCount;
	private double totalPercentage;
	private double totalValue;
	private double availableCount;
	private double availableValue;
	private double finalCount;
	private double subtotal;
	private double tax;
	private double total;
	
	
	public ProjectionReport() {
		
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getHiredPrice() {
		return hiredPrice;
	}
	public void setHiredPrice(double hiredPrice) {
		this.hiredPrice = hiredPrice;
	}
	public double getHiredCount() {
		return hiredCount;
	}
	public void setHiredCount(double hiredCount) {
		this.hiredCount = hiredCount;
	}
	public double getHiredValue() {
		return hiredValue;
	}
	public void setHiredValue(double hiredValue) {
		this.hiredValue = hiredValue;
	}
	public double getPreviousCount() {
		return previousCount;
	}
	public void setPreviousCount(double previousCount) {
		this.previousCount = previousCount;
	}
	public double getPreviousValue() {
		return previousValue;
	}
	public void setPreviousValue(double previousValue) {
		this.previousValue = previousValue;
	}
	public double getActualCount() {
		return actualCount;
	}
	public void setActualCount(double actualCount) {
		this.actualCount = actualCount;
	}
	public double getActualValue() {
		return actualValue;
	}
	public void setActualValue(double actualValue) {
		this.actualValue = actualValue;
	}
	public double getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(double totalCount) {
		this.totalCount = totalCount;
	}
	public double getTotalPercentage() {
		return totalPercentage;
	}
	public void setTotalPercentage(double totalPercentage) {
		this.totalPercentage = totalPercentage;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	public double getAvailableCount() {
		return availableCount;
	}
	public void setAvailableCount(double availableCount) {
		this.availableCount = availableCount;
	}
	public double getAvailableValue() {
		return availableValue;
	}
	public void setAvailableValue(double availableValue) {
		this.availableValue = availableValue;
	}
	public double getFinalCount() {
		return finalCount;
	}
	public void setFinalCount(double finalCount) {
		this.finalCount = finalCount;
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
	
	
	
}
