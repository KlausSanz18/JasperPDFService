package com.example.JasperPDF.mapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Springboot.viewModel.reports.EconomicSummary;
import com.example.Springboot.viewModel.reports.IntersectionActivity;
import com.example.Springboot.viewModel.reports.ProjectionReport;
import com.example.Springboot.viewModel.reports.TechnicalReport;
import com.example.Springboot.viewModel.reports.IntersectionReport;
import com.example.Springboot.viewModel.reports.ItemManagement;
import com.example.Springboot.viewModel.reports.PreBilling;


public class PDFMapper {
	
	public List<Map<String, ?>> mapEconomic(List<EconomicSummary> list){
		List<Map<String,?>> listresumen = new ArrayList<Map<String, ?>>();
		
		Double Total = 0.00;
		for(EconomicSummary rep : list ) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("Item", rep.getCode());
			m.put("Fecha", rep.getStartDate());
			m.put("Descripcion", rep.getDescription());
			m.put("Cantidad", rep.getQuantity());
			m.put("Precio", rep.getPrice());
			m.put("subtotal", rep.getSubtotal());
			m.put("Tax", rep.getTax());
			m.put("Total",rep.getTotal());
			Total = Total + (rep.getQuantity()*rep.getPrice());
			m.put("SubTotals",Total);
			m.put("Taxs",Total *0.18);
			m.put("Totals",Total *1.18);
			
			listresumen.add(m);
			
		}
		return listresumen;
	}

	public List<Map<String, ?>> mapProjection(List<ProjectionReport> list){
		List<Map<String,?>> listdinamico = new ArrayList<Map<String, ?>>();
		
		for(ProjectionReport rep : list ) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("Descripcion", rep.getDescription());
			m.put("Precio_item", rep.getHiredPrice());
			m.put("Unidades_contratada", rep.getHiredCount());
			m.put("valor_cantratada", rep.getHiredValue());
			m.put("Unidades_ejecutadas", rep.getTotalCount());
			m.put("%_ejecutadas", rep.getTotalPercentage());
			m.put("Valor_ejecutadas", rep.getTotalValue());
			m.put("Unidades_proyectadas", rep.getAvailableCount());
			m.put("Valor_proyectadas", rep.getAvailableValue() );
			m.put("Unidades_total", rep.getAvailableCount());
			m.put("Valor_total", rep.getAvailableValue());
			m.put("subtotal",rep.getSubtotal());
			m.put("tax", rep.getTax());
			m.put("total", rep.getTotal());
			
			listdinamico.add(m);	
		}

		return listdinamico;
	}

	public List<Map<String, ?>> mapTechnical(List<TechnicalReport> list){
		List<Map<String,?>> listTecnico = new ArrayList<Map<String, ?>>();
		
		for(TechnicalReport rep : list ) {
			Map<String, Object> m = new HashMap<String, Object>();
			
			m.put("Fecha", rep.getStartDate() );
			m.put("Item", rep.getCode());
			m.put("ubicacion", rep.getLocation());
			m.put("Descripcion", rep.getDescription());
			m.put("Cantidad", rep.getQuantity());
			m.put("Funcionario", rep.getEmployee());
			m.put("Orden", Integer.parseInt(rep.getOrderNo()));
			
			listTecnico.add(m);
		}
		
		return listTecnico;
	}

	public List<Map<String, ?>> findAutomatico(List<ProjectionReport> list){
		List<Map<String,?>> listautomatico = new ArrayList<Map<String, ?>>();
		
		for(ProjectionReport rep : list ) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("Descripcion", rep.getDescription());
			m.put("Precio_item", rep.getHiredPrice());
			m.put("Unidades_contratada", rep.getHiredCount());
			m.put("valor_cantratada", rep.getHiredValue());
			m.put("Unidades_ejecutadas", rep.getPreviousCount() + rep.getActualCount());
			m.put("%_ejecutadas", (rep.getPreviousCount() + rep.getActualCount()) / rep.getHiredCount());
			m.put("Valor_ejecutadas", rep.getPreviousValue() + rep.getActualValue());
			m.put("Unidades_proyectadas", rep.getAvailableCount());
			m.put("Valor_proyectadas", rep.getAvailableValue());
			m.put("Unidades_total", rep.getFinalCount());
			m.put("Valor_total", rep.getTotal());
			m.put("subtotal",rep.getSubtotal());
			m.put("tax", rep.getTax());
			m.put("total", rep.getTotal());
			
			listautomatico.add(m);
			
		}

		return listautomatico;
	}

	public List<Map<String, ?>> findProyecciones(List<ProjectionReport> list){
		List<Map<String,?>> listproyecciones = new ArrayList<Map<String, ?>>();
		Double[] totals = new Double[3];
		totals[0] = 0.00;
		for(ProjectionReport rep : list ) {
			Map<String, Object> m = new HashMap<String, Object>();
			Date generated = new Date();

			m.put("Descripcion", rep.getDescription());
			m.put("Precio", rep.getHiredPrice());
			m.put("Unidades_contratada", rep.getHiredCount());
			m.put("Monto_contratada", rep.getHiredValue());
			
			m.put("Unidades_acumulada", rep.getPreviousCount());
			m.put("Monto_acumulada", rep.getPreviousValue());
			m.put("Unidades_ejecutadas", rep.getActualCount());
			m.put("Monto_ejecutadas", rep.getActualValue());
			
			m.put("UnidadesTotalE", rep.getFinalCount());
			m.put("Monto_TotalE", rep.getFinalCount() * rep.getHiredPrice());
			m.put("Unidades_disponibles", rep.getAvailableCount());
			m.put("Monto_disponibles", rep.getAvailableValue());
			m.put("Categoria", rep.getCategory());
			m.put("subtotal",rep.getSubtotal());
			m.put("tax", rep.getTax());
			m.put("total", rep.getTotal());
			m.put("generationDate", generated);

			listproyecciones.add(m);
		}
		return listproyecciones;
	}



	public List<Map<String, ?>> findInterseccion(List<IntersectionReport> list){
		List<Map<String,?>> ListIndividual = new ArrayList<Map<String, ?>>();
		
		Date generated = new Date();
		for( IntersectionReport rep : list ) {
			
			
			for (IntersectionActivity o : rep.getEquipment()) {

				Map<String, Object> m = new HashMap<String, Object>();
				m.put("Descripcion", o.getIntersectionDescription());
				m.put("Item", o.getCode());
				m.put("Itemdes", o.getDescription());
				m.put("Cantidad", o.getPreviousQuantity());
				m.put("Valor", o.getPreviousValue() );
				m.put("Categoria", o.getCategory());
				m.put("Mes", o.getThisMonthQuantity());
				m.put("Precio", o.getThisMonthValue());
				m.put("total", o.getOverallQuantity());
				m.put("valorMes", o.getOverallValue());
				m.put("generationDate", generated);
	
				ListIndividual.add(m);
			}

			for (IntersectionActivity o : rep.getServices()) {
				Map<String, Object> m = new HashMap<String, Object>();

				m.put("Descripcion", o.getIntersectionDescription());
				m.put("Item", o.getCode());
				m.put("Itemdes", o.getDescription());
				m.put("Cantidad", o.getPreviousQuantity());
				m.put("Valor", o.getPreviousValue() );
				m.put("Categoria", o.getCategory());
				m.put("Mes", o.getThisMonthQuantity());
				m.put("Precio", o.getThisMonthValue());
				m.put("total", o.getOverallQuantity());
				m.put("valorMes", o.getOverallValue());
				m.put("generationDate", generated);
	
				ListIndividual.add(m);
			}

			for (IntersectionActivity o : rep.getMaterials()) {

				Map<String, Object> m = new HashMap<String, Object>();

				m.put("Descripcion", o.getIntersectionDescription());
				m.put("Item", o.getCode());
				m.put("Itemdes", o.getDescription());
				m.put("Cantidad", o.getPreviousQuantity());
				m.put("Valor", o.getPreviousValue() );
				m.put("Categoria", o.getCategory());
				m.put("Mes", o.getThisMonthQuantity());
				m.put("Precio", o.getThisMonthValue());
				m.put("total", o.getOverallQuantity());
				m.put("valorMes", o.getOverallValue());
				m.put("generationDate", generated);
	
				ListIndividual.add(m);
			}
		
		}
			return ListIndividual;
	}




	public List<Map<String, ?>> findConsultas(List<TechnicalReport> list){
		List<Map<String,?>> listConsulta = new ArrayList<Map<String, ?>>();
		
		Double Total = 0.00;
		
		for(TechnicalReport rep : list ) {
			Map<String, Object> m = new HashMap<String, Object>();
			
			//mapeo de los valores para que jasper los reconozca
			m.put("Fecha", rep.getStartDate());
			m.put("Item", rep.getCode());
			m.put("ubicacion", rep.getLocation());
			m.put("Descripcion", rep.getDescription());
			m.put("Cantidad", rep.getQuantity());
			m.put("Funcionario", rep.getEmployee());
			m.put("Orden", Integer.parseInt(rep.getOrderNo()));
			//Total = Total + (rep.getCantidad()*rep.);
			m.put("SubTotals",Total);
			m.put("Taxs",Total *0.18);
			m.put("Totals",Total *1.18);
			
			listConsulta.add(m);
			
		}
		return listConsulta;
	}





	public List<Map<String, ?>> findFactura(List<PreBilling> list){
		List<Map<String,?>> listfact = new ArrayList<Map<String, ?>>();
		Double[] valor = new Double[3];
		valor[0] = 0.00;
		valor[1] = 0.00;
		valor[2] = 0.00;
		Map<String, Object> m = new HashMap<String, Object>();
		
		for( PreBilling rep : list ) {
			
			switch(rep.getCategory()) {
							
			case "Servicios":
				valor[0] = valor[0] + rep.getTotalValue();
				
				
				break;
			case "Materiales":
				valor[1] = valor[1] + rep.getTotalValue();
				
				break;
			case "Equipos": 
				valor[2] = valor[2] + rep.getTotalValue();
				
				break;
			default: 
				break;
			
			}

		}
		
		m.put("servicios", valor[0]);
		m.put("materiales", valor[1]);
		m.put("equipos", valor[2]);
		m.put("fecha1", new Date());
		m.put("fecha2", new Date());

		// System.out.println("Probando fecha 1: "+date1);
		// System.out.println("Probando fecha 2: "+date2);
		
		listfact.add(m);
		return listfact;
	}






	public List<Map<String, ?>> findFactura2(List<PreBilling> list){
		List<Map<String,?>> ListFactura2 = new ArrayList<Map<String, ?>>();

	
		Double[] valor = {0.00,0.00,0.00};
		Double[] thisMonth = {0.00,0.00,0.00};
		Double[] lastMonth = {0.00,0.00,0.00};
		
		Map<String, Object> m = new HashMap<String, Object>();
		
		for( PreBilling rep : list ) {
			
		
			//mapeo de los valores para que jasper los reconozca
	
			switch(rep.getCategory()) {
							
			case "Servicios":
				thisMonth[0] = thisMonth[0] + (rep.getActualValue());
				lastMonth[0] = lastMonth[0] + (rep.getPreviousValue());
				valor[0] = (thisMonth[0] + lastMonth[0]);
			   
			  
				break;
			case "Materiales":
				thisMonth[1] = thisMonth[1] + (rep.getActualValue());
				lastMonth[1] = lastMonth[1] + (rep.getPreviousValue());
				valor[1] = (thisMonth[1] + lastMonth[1]);
				 
				break;
			case "Equipos": 
				thisMonth[2] = thisMonth[2] + (rep.getActualValue());
				lastMonth[2] = lastMonth[2] + (rep.getPreviousValue());
				valor[2] = (thisMonth[2] + lastMonth[2]);
				
				break;
			default: 
				break;
			
			}

		}
		m.put("valorS", valor[0]);
		m.put("valorM", valor[1]);
		m.put("valorE", valor[2]);
		
		m.put("lastMonthE", lastMonth[2]);
		m.put("thisMonthE", thisMonth[2]);
		
		m.put("lastMonthM", lastMonth[1]);
		m.put("thisMonthM", thisMonth[1]);
		
		m.put("lastMonthS", lastMonth[0]);
		m.put("thisMonthS", thisMonth[0]);
		
		ListFactura2.add(m);
		return ListFactura2;
	}



	public List<Map<String, ?>> findEjecucion(List<ItemManagement> list){
		List<Map<String,?>> ListIndividual = new ArrayList<Map<String, ?>>();
		
		Double Total = 0.00;
		
		for(ItemManagement rep : list ) {
			Map<String, Object> m = new HashMap<String, Object>();
			
			//mapeo de los valores para que jsper los reconozca
			m.put("Fecha", rep.getStartDate());
			m.put("noOrden", rep.getOrderNo());
			m.put("ubicacion", rep.getLocation());
			m.put("Cantidad", rep.getQuantity());
		
			
			ListIndividual.add(m);
		}
		

		return ListIndividual;
	}



	
}
