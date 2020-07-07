package com.example.Springboot.viewModel.reports;

public class PreBilling {
    private double previousValue;
    private double actualValue;
    private double totalValue;
    private String category;
    
    public PreBilling() {
    }

    public PreBilling(
        double previousValue, 
        double actualValue, 
        double totalValue, 
        String category) {

            this.previousValue = previousValue;
            this.actualValue = actualValue;
            this.totalValue = totalValue;
            this.category = category;
    }
    

    public double getPreviousValue() {
        return previousValue;
    }

    public void setPreviousValue(double previousValue) {
        this.previousValue = previousValue;
    }

    public double getActualValue() {
        return actualValue;
    }

    public void setActualValue(double actualValue) {
        this.actualValue = actualValue;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}