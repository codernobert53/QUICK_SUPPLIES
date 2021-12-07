package com.quick.supplies.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.quick.supplies.domain.OrdersMade;

public class DownloadOrdersPdf extends AbstractPdfView{
	@Override
	 protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request,
	   HttpServletResponse response) throws Exception {
	  
	  response.setHeader("Content-Disposition", "attachment; filename=\"orders.pdf\"");
	  
	  @SuppressWarnings("unchecked")
	  List<OrdersMade> list = (List<OrdersMade>) model.get("ordersList");
	  
	  Table table = new Table(8);
	  table.addCell("productId");
	  table.addCell("owner");
	  table.addCell("contact");
	  table.addCell("product");
	  table.addCell("weight");
	  table.addCell("quantity");
	  table.addCell("unitPrice");
	  table.addCell("description");
	  
	  for(OrdersMade ordersMade : list){
	   table.addCell(ordersMade.getProductId());
	   table.addCell(ordersMade.getOwner());
	   table.addCell(ordersMade.getContact());
	   table.addCell(ordersMade.getProduct());
	   table.addCell(ordersMade.getWeight());
	   table.addCell(ordersMade.getQuantity());
	   table.addCell(ordersMade.getUnitPrice());
	   table.addCell(ordersMade.getDescription());
	   
	  }
	  
	  document.add(table);
	 }
}
