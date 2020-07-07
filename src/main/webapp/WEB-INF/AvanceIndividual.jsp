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
	List<Map<String, ?>> dataSource = (List<Map<String, ?>>) request.getAttribute("ListIndividual");
	
	JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);

	String jrxmlFile = session.getServletContext().getRealPath("\\META-INF\\jrxml\\ReporteporCategoria.jrxml");
	System.out.println("Vista Individual");

	InputStream input = new FileInputStream(new File(jrxmlFile));

	JasperReport jasperReport = JasperCompileManager.compileReport(input);

	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrDataSource);

	JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	response.getOutputStream().flush();
	response.getOutputStream().close();
	
	
	
} catch (Exception e) {
	e.printStackTrace();
}
%>