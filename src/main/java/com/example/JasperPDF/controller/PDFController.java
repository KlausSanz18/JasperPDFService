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


import com.example.JasperPDF.mapper.PDFMapper;
import com.example.Springboot.viewModel.reports.EconomicSummary;

import com.example.Springboot.viewModel.reports.ProjectionReport;
import com.example.Springboot.viewModel.reports.TechnicalReport;
import com.example.Springboot.viewModel.reports.IntersectionReport;
import com.example.Springboot.viewModel.reports.IntersectionActivity;
import com.example.Springboot.viewModel.reports.PreBilling;
import com.example.Springboot.viewModel.reports.ItemManagement;
import com.example.Springboot.viewModel.reports.ProjectProgress;

@Controller
@CrossOrigin
@RequestMapping("/PDF")
public class PDFController {
	
	PDFMapper mapper = new PDFMapper();
	
	List<PreBilling> preBilling = new LinkedList<PreBilling>();
	List<EconomicSummary> economicSummary = new LinkedList<EconomicSummary>();
	List<ProjectionReport> projectionReport = new LinkedList<ProjectionReport>();
	List<TechnicalReport> technicalReport = new LinkedList<TechnicalReport>();
	List<IntersectionReport> intersectionReport = new LinkedList<IntersectionReport>();
	List<IntersectionActivity> intersectionActivity = new LinkedList<IntersectionActivity>();
	List<ItemManagement> itemManagement = new LinkedList<ItemManagement>();
	List<ProjectProgress> projectProgress = new LinkedList<ProjectProgress>();

	
	@PostMapping("/reporte-general")
	public String getTest(@RequestBody List<EconomicSummary> source) {
		economicSummary.clear();
		for(EconomicSummary r : source) {
			economicSummary.add(r);
		}

		return "ResumenGeneral";
	}
	
	@GetMapping("/reporte-general")
	public String getPDF(ModelMap model) {
		model.put("ListResumen", mapper.mapGeneral(economicSummary));
		return "ResumenGeneral";
	}


	@PostMapping("/reporte-economico")
	public String setEconimics(@RequestBody List<EconomicSummary> source) {
		economicSummary.clear();
		for(EconomicSummary r : source) {
			economicSummary.add(r);
		}

		return "ResumenEconomico";
	}
	
	@GetMapping("/reporte-economico")
	public String getEconimics(ModelMap model) {
		model.put("ListResumen", mapper.mapEconomic(economicSummary));
		return "ResumenEconomico";
	}
	
	@PostMapping("/Proyeccion")
	public String setData(@RequestBody List<ProjectionReport> source) {
		projectionReport.clear();
		for(ProjectionReport r : source) {
			projectionReport.add(r);
		}

		return "ReporteAutomatico";
	}

	@GetMapping("/Proyeccion")
	public String getProyection(ModelMap model){
		model.put("ListProjection", mapper.mapProjection2(projectionReport));
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

	@PostMapping("/reporte-tecnico2")
	public String goEconomicSummary(@RequestBody List<TechnicalReport> source) {
		technicalReport.clear();
		for(TechnicalReport es : source) {
			technicalReport.add(es);
		}

		return "ReporteTecnico";
	}

	@GetMapping("/reporte-tecnico2")
	public String goEconomicSummary(ModelMap model) {
		model.put("ListTecnico", mapper.mapTechnical(technicalReport));
		return "ReporteTecnico";
	}

	
	@PostMapping("/avance-individual")
	public String consultarInterseccion2(@RequestBody List<IntersectionReport> source){
		System.out.println("Controller POST Individual");
		intersectionReport.clear();
		for(IntersectionReport es : source) {
			intersectionReport.add(es);
		}

		return "AvanceIndividual";
	}


	@GetMapping("/avance-individual")
	public String consultarInterseccion2(ModelMap model){
		model.put("ListIndividual", mapper.findInterseccion(intersectionReport));
		System.out.println("Controller GET Individual");
		return "AvanceIndividual";
	}


	@PostMapping("/avance-general")
	public String setGeneralAdvance(@RequestBody List<ProjectProgress> source){
		projectionReport.clear();
		for(ProjectProgress es : source) {
			projectProgress.add(es);
		}

		return "AvanceGeneral";
	}


	@GetMapping("/avance-general")
	public String getGeneralAdvance(ModelMap model){
		model.put("ListAvances", mapper.findProyecciones2(projectProgress));
		return "AvanceGeneral";
	}

	@PostMapping("/avance-presupuesto")
    public String getBudgetP(@RequestBody List<ProjectionReport> source) {
		projectionReport.clear();
		for(ProjectionReport es : source) {
			projectionReport.add(es);
		}

		return "AvancePresupuesto";
	}
	
	@GetMapping("/avance-presupuesto")
    public String getBudgetP(ModelMap model) {
		model.put("listproyecciones", mapper.findProyecciones(projectionReport));
		return "AvancePresupuesto";
	}

	@PostMapping("/busqueda-general")
	public String getPDFConsultas(@RequestBody List<TechnicalReport> source) {
		technicalReport.clear();
		for(TechnicalReport es : source) {
			technicalReport.add(es);
		}
		return "BusquedaGeneral";
	}

	@GetMapping("/busqueda-general")
	public String getPDFConsultas(ModelMap model) {
		model.put("listConsulta", mapper.findConsultas(technicalReport));
		return "BusquedaGeneral";
	}


	@PostMapping("/busqueda-individual")
	public String getPDFbusquedaIndividual(@RequestBody List<ItemManagement> source) {
		itemManagement.clear();
		for(ItemManagement es : source) {
			itemManagement.add(es);
		}
		return "BusquedaIndividual";
	}

	@GetMapping("/busqueda-individual")
	public String getPDFbusquedaIndividual(ModelMap model) {
		model.put("ListIndividual", mapper.findEjecucion(itemManagement));
		return "BusquedaIndividual";
	}


	@PostMapping("/facturacion-prefacturacion")
    public String getPDFPrefacturacion(@RequestBody List<PreBilling> source) {
		preBilling.clear();
		for(PreBilling es : source) {
			preBilling.add(es);
		}
		return "FacturacionPrefacturacion";
	}
	
	@GetMapping("/facturacion-prefacturacion")
    public String getPDFPrefacturacion(ModelMap model) {
		model.put("ListFactura", mapper.findFactura(preBilling));
		return "FacturacionPrefacturacion";
	}
	


	@PostMapping("/facturacion-prefacturacion2")
    public String getPDFPrefacturacion2_acumulado(@RequestBody List<PreBilling> source) {
		preBilling.clear();
		for(PreBilling es : source) {
			preBilling.add(es);
		}
		return "FacturacionPrefacturacion2";
	}
	
	@GetMapping("/facturacion-prefacturacion2")
    public String getPDFPrefacturacion2_acumulado(ModelMap model) {
		model.put("ListFactura2", mapper.findFactura2(preBilling));
		return "FacturacionPrefacturacion2";
	}
	
    //no disponible
	@PostMapping(value = "/busqueda-actividad")
	public String getPDFBusqueda_actividad(@RequestBody List<PreBilling> source) {
		preBilling.clear();
		for(PreBilling es : source) {
			preBilling.add(es);
		}
		return "busquedaConActividad";
	}

	@GetMapping(value = "/busqueda-actividad")
	public String getPDFBusqueda_actividad(ModelMap model) {
		model.put("ListFactura2", mapper.findFactura2(preBilling));
		return "busquedaConActividad";
	}
}
