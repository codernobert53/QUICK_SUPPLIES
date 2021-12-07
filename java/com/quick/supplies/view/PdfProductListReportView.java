package com.quick.supplies.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.quick.supplies.domain.Product;

public class PdfProductListReportView extends AbstractPdfView{

	@Override
	 protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request,
	   HttpServletResponse response) throws Exception {
	  
	  response.setHeader("Content-Disposition", "attachment; filename=\"product_list.pdf\"");
	  
	  @SuppressWarnings("unchecked")
	  List<Product> list = (List<Product>) model.get("productList");
	  
	  Table table = new Table(9);
	  table.addCell("productId");
	  table.addCell("owner");
	  table.addCell("unitPrice");
	  table.addCell("description");
	  table.addCell("product");
	  table.addCell("location");
	  table.addCell("weight");
	  table.addCell("contact");
	  table.addCell("quantity");
	  
	  for(Product product : list){
	   table.addCell(product.getProductId());
	   table.addCell(product.getOwner());
	   table.addCell(product.getUnitPrice());
	   table.addCell(product.getDescription());
	   table.addCell(product.getProduct());
	   table.addCell(product.getLocation());
	   table.addCell(product.getWeight());
	   table.addCell(product.getContact());
	   table.addCell(product.getQuantity());
	  }
	  
	  document.add(table);
	 }
	
}
