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

public class DownloadReceipt extends AbstractPdfView{
	@Override
	 protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request,
	   HttpServletResponse response) throws Exception {
	  
	  response.setHeader("Content-Disposition", "attachment; filename=\"receipt_list.pdf\""); 
	  @SuppressWarnings("unchecked")
	  List <OrdersMade> list = (List<OrdersMade>) model.get("receiptList");
	  
	  Table table = new Table(6);
	  table.addCell("productId");
	  table.addCell("owner");
	  table.addCell("unitPrice");
	  table.addCell("product");
	  table.addCell("contact");
	  table.addCell("quantity");
	  
	  for(OrdersMade rec : list){
		  
		  
	   table.addCell(rec.getProductId());
	   table.addCell(rec.getOwner());
	   table.addCell(rec.getUnitPrice());
	   table.addCell(rec.getProduct());
	   table.addCell(rec.getContact());
	   table.addCell(rec.getQuantity());
	  }
	  
	  document.add(table);
	 }
	
}
