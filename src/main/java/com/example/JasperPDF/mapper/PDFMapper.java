package com.example.JasperPDF.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Springboot.viewModel.reports.EconomicSummary;
import com.example.Springboot.viewModel.reports.ProjectionReport;
import com.example.Springboot.viewModel.reports.TechnicalReport;


public class PDFMapper {
	
	public List<Map<String, ?>> mapEconomic(List<EconomicSummary> list){
		List<Map<String,?>> listresumen = new ArrayList<Map<String, ?>>();
		
		Double Total = 0.00;
		for(EconomicSummary rep : list ) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("Item", rep.getCode());
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
			//m.put("Categoria", rep.getCategory());
			m.put("subtotal",rep.getSubtotal());
			m.put("tax", rep.getTax());
			m.put("total", rep.getTotal());
			
			listproyecciones.add(m);
		}
		return listproyecciones;
	}



	
}
