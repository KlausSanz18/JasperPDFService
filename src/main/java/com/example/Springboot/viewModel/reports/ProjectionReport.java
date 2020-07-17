package com.example.Springboot.viewModel.reports;

public class ProjectionReport {

	private String description;
	private String category;
	private double hiredPrice;
	private double hiredCount;
	private double hiredValue;
	private double previousCount;
	private double previousValue;
	private double previousValue2;
	private double actualCount;
	private double actualValue;
	private double totalCount;
	private double totalPercentage;
	private double totalValue;
	private double availableCount;
	private double availableCount2;
	private double availableValue;
	private double finalCount;
	private Double subtotal;
	private double tax;
	private double total;
	private double projectedValue;
	private double total_unidades;
	
	
	public ProjectionReport() {
		// this.previousValue2 =(hiredPrice*previousValue);
		// this.projectedValue = (hiredPrice*availableCount);
		// if (this.availableCount2 >0) {
		// 	this.setPreviousValue2(previousValue2 * hiredPrice);
		// }else {
		// 	this.setPreviousValue2(totalCount * hiredPrice);
		// }
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

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPreviousValue2() {
		return previousValue2;
	}

	public void setPreviousValue2(double previousValue2) {
		this.previousValue2 = previousValue2;
	}

	public double getAvailableCount2() {
		return availableCount2;
	}

	public void setAvailableCount2(double availableCount2) {
		this.availableCount2 = availableCount2;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getProjectedValue() {
		return projectedValue;
	}

	public void setProjectedValue(double projectedValue) {
		this.projectedValue = projectedValue;
	}

	public double getTotal_unidades() {
		return total_unidades;
	}

	public void setTotal_unidades(double total_unidades) {
		this.total_unidades = total_unidades;
	}
	
	
	
}
