package com.example.Springboot.viewModel.reports;

public class IntersectionActivity{
	private String code;
	private String description;
	private double previousQuantity;
	private double previousValue;
	private double thisMonthQuantity;
	private double thisMonthValue;
	private double overallQuantity;
	private double overallValue;
	private String category;
	private int intersectionId;
	private String intersectionDescription;
	private double activityPrice;
	
	public IntersectionActivity() {
		
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
	public double getPreviousQuantity() {
		return previousQuantity;
	}
	public void setPreviousQuantity(double previousQuantity) {
		this.previousQuantity = previousQuantity;
	}
	public double getPreviousValue() {
		return previousValue;
	}
	public void setPreviousValue(double previousValue) {
		this.previousValue = previousValue;
	}
	public double getThisMonthQuantity() {
		return thisMonthQuantity;
	}
	public void setThisMonthQuantity(double thisMonthQuantity) {
		this.thisMonthQuantity = thisMonthQuantity;
	}
	public double getThisMonthValue() {
		return thisMonthValue;
	}
	public void setThisMonthValue(double thisMonthValue) {
		this.thisMonthValue = thisMonthValue;
	}
	public double getOverallQuantity() {
		return overallQuantity;
	}
	public void setOverallQuantity(double overallQuantity) {
		this.overallQuantity = overallQuantity;
	}
	public double getOverallValue() {
		return overallValue;
	}
	public void setOverallValue(double overallValue) {
		this.overallValue = overallValue;
	}
	public int getIntersectionId() {
		return intersectionId;
	}
	public void setIntersectionId(int intersectionId) {
		this.intersectionId = intersectionId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public String getIntersectionDescription() {
		return intersectionDescription;
	}

	public void setIntersectionDescription(String intersectionDescription) {
		this.intersectionDescription = intersectionDescription;
	}

	public double getActivityPrice() {
		return activityPrice;
	}

	public void setActivityPrice(double activityPrice) {
		this.activityPrice = activityPrice;
	}
	
	
}
