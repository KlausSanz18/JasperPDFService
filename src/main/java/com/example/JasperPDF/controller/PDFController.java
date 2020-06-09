package com.example.JasperPDF.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.JasperPDF.mapper.PDFMapper;
import com.example.Springboot.viewModel.reports.EconomicSummary;
import com.example.Springboot.viewModel.reports.GeneralReport;
import com.example.Springboot.viewModel.reports.ProjectionReport;
import com.example.Springboot.viewModel.reports.TechnicalReport;

@Controller
@CrossOrigin
@RequestMapping("/PDF")
public class PDFController {
	
	PDFMapper mapper = new PDFMapper();
	
	List<EconomicSummary> economicSummary = new LinkedList<EconomicSummary>();
	List<ProjectionReport> projectionReport = new LinkedList<ProjectionReport>();
	List<TechnicalReport> technicalReport = new LinkedList<TechnicalReport>();
	
	@PostMapping("/Summary")
	public String getTest(@RequestBody List<EconomicSummary> source) {
		economicSummary.clear();
		for(EconomicSummary r : source) {
			economicSummary.add(r);
		}

		return "ResumenEconomico";
	}
	
	@GetMapping("/Summary")
	public String getPDF(ModelMap model) {
		model.put("ListResumen", mapper.mapEconomic(economicSummary));
		return "ResumenEconomico";
	}
	
	@PostMapping("/Proyeccion")
	public String setData(@RequestBody List<ProjectionReport> source) {
		for(ProjectionReport r : source) {
			projectionReport.add(r);
		}

		return "ReporteAutomatico";
	}

	@GetMapping("/Proyeccion")
	public String getProyection(ModelMap model){
		model.put("ListProjection", mapper.mapProjection(projectionReport));
		return "ReporteAutomatico";
	}

	@PostMapping("/Avance/Presupuesto")
	public String setAvailable(@RequestBody List<ProjectionReport> source) {
		for(ProjectionReport r : source) {
			projectionReport.add(r);
		}
		return "ReporteProyecciones";
	}

	@GetMapping("/Avance/Presupuesto")
	public String getAvailable(ModelMap model){
		model.put("reportRows", mapper.mapProjection(projectionReport));
		return "ReporteProyecciones";
	}
}
