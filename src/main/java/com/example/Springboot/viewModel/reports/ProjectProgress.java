package com.example.Springboot.viewModel.reports;

public class ProjectProgress {
	private String aDescription;
	private double aPrice;
	private String aType;
	private double aHiredCount;
	private double aHiredValue;
	private double previousCount;
	private double previousValue;
	private double actualCount;
	private double actualValue;
	private double totalCount;
	private double totalValue;
	
	public ProjectProgress() {
		
	}
	
	public String getaDescription() {
		return aDescription;
	}
	public void setaDescription(String aDescription) {
		this.aDescription = aDescription;
	}
	public double getaPrice() {
		return aPrice;
	}
	public void setaPrice(double aPrice) {
		this.aPrice = aPrice;
	}
	public double getaHiredCount() {
		return aHiredCount;
	}
	public void setaHiredCount(double aHiredCount) {
		this.aHiredCount = aHiredCount;
	}
	public double getaHiredValue() {
		return aHiredValue;
	}
	public void setaHiredValue(double aHiredValue) {
		this.aHiredValue = aHiredValue;
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
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public String getaType() {
		return aType;
	}

	public void setaType(String aType) {
		this.aType = aType;
	}
	
	
}
