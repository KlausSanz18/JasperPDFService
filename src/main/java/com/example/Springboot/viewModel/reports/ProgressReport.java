package com.example.Springboot.viewModel.reports;

import java.util.LinkedList;
import java.util.List;

public class ProgressReport {
	private List<ProjectProgress> services;
	private List<ProjectProgress> equipment;
	private List<ProjectProgress> materials;
	
	public ProgressReport() {
		this.services = new LinkedList<ProjectProgress>();
		this.equipment = new LinkedList<ProjectProgress>();
		this.materials = new LinkedList<ProjectProgress>();
	}
	public List<ProjectProgress> getServices() {
		return services;
	}
	public void setServices(List<ProjectProgress> services) {
		this.services = services;
	}
	public List<ProjectProgress> getEquipment() {
		return equipment;
	}
	public void setEquipment(List<ProjectProgress> equipment) {
		this.equipment = equipment;
	}
	public List<ProjectProgress> getMaterials() {
		return materials;
	}
	public void setMaterials(List<ProjectProgress> materials) {
		this.materials = materials;
	}
}
