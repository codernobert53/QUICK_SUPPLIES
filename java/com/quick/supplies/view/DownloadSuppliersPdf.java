package com.quick.supplies.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.quick.supplies.domain.Supplier;

public class DownloadSuppliersPdf extends AbstractPdfView{
	@Override
	 protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request,
	   HttpServletResponse response) throws Exception {
	  
	  response.setHeader("Content-Disposition", "attachment; filename=\"suppliers.pdf\"");
	  
	  @SuppressWarnings("unchecked")
	  List <Supplier> list = (List<Supplier>) model.get("suppliersList");
	  
	  Table table = new Table(3);
	  table.addCell("name");
	  table.addCell("contact");
	  table.addCell("address");

	  
	  for(Supplier supplier : list){
	   table.addCell(supplier.getName());
	   table.addCell(supplier.getContact());
	   table.addCell(supplier.getAddress());

	   
	  }
	  
	  document.add(table);
	 }
}
