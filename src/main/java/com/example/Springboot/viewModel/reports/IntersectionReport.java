package com.example.Springboot.viewModel.reports;

import java.util.LinkedList;
import java.util.List;

public class IntersectionReport {
	
	private String description;
	private List<IntersectionActivity> materials;
	private List<IntersectionActivity> services;
	private List<IntersectionActivity> equipment;
	
	public IntersectionReport() {
		this.materials = new LinkedList<IntersectionActivity>();
		this.services = new LinkedList<IntersectionActivity>();
		this.equipment = new LinkedList<IntersectionActivity>();
	}
	public List<IntersectionActivity> getMaterials() {
		return materials;
	}
	public void setMaterials(List<IntersectionActivity> materials) {
		this.materials = materials;
	}
	public List<IntersectionActivity> getServices() {
		return services;
	}
	public void setServices(List<IntersectionActivity> services) {
		this.services = services;
	}
	public List<IntersectionActivity> getEquipment() {
		return equipment;
	}
	public void setEquipment(List<IntersectionActivity> equipment) {
		this.equipment = equipment;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}