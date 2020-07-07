<%@ page contentType="application/pdf"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="net.sf.jasperreports.engine.*"%>
<%@ page import="net.sf.jasperreports.engine.data.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%

try {
	//OBTIENE LOS VALORES DEL CONTROLADOR
	List<Map<String, ?>> dataSource = (List<Map<String, ?>>) request.getAttribute("ListFactura2");
	
	// CREA UNA VARIABLE TIPO JRBeanCollectionDataSource y le pasa los valores del controlador
	
	JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
// 	SE OBTIENE LA DIRECCION DEL REPORTE JASPER

	String jrxmlFile = session.getServletContext().getRealPath("META-INF\\jrxml\\ReporteFacturaAcumulado.jrxml");
	//DECLARAMOS UNA VARIABLE TIPO INPUT STREAM  PARA ACCEDER AL ARCHIVO
	InputStream input = new FileInputStream(new File(jrxmlFile));
	//COMPILAMOS EL ARCHIVO JRXML
	JasperReport jasperReport = JasperCompileManager.compileReport(input);
	// LLENAMOS EL ARCHIVO COMPILADO CON LOS DATOS DE LA LISTA
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrDataSource);
	// EXPORTAMOS A PDF
	JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	response.getOutputStream().flush();
	response.getOutputStream().close();
	
	
	
} catch (Exception e) {
	e.printStackTrace();
}
%>