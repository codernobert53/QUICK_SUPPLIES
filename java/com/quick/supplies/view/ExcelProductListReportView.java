package com.quick.supplies.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.quick.supplies.domain.Product;

public class ExcelProductListReportView extends AbstractXlsView{

	@Override
	 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
	   HttpServletResponse response) throws Exception {
	  
	  response.setHeader("Content-disposition", "attachment; filename=\"product_list.xls\"");
	  
	  @SuppressWarnings("unchecked")
	  List<Product> list = (List<Product>) model.get("productList");
	  
	  Sheet sheet = workbook.createSheet("User List");
	  
	  Row header = sheet.createRow(0);
	  header.createCell(0).setCellValue("productId");
	  header.createCell(1).setCellValue("owner");
	  header.createCell(1).setCellValue("unitPrice");
	  header.createCell(2).setCellValue("description");
	  header.createCell(3).setCellValue("product");
	  header.createCell(4).setCellValue("location");
	  header.createCell(5).setCellValue("weight");
	  header.createCell(6).setCellValue("contact");
	  header.createCell(7).setCellValue("quantity");

	  
	  int rowNum = 1;
	  
	  for(Product product : list){
	   Row row = sheet.createRow(rowNum++);
	   
	   row.createCell(0).setCellValue(product.getProductId());
	   row.createCell(1).setCellValue(product.getOwner());
	   row.createCell(1).setCellValue(product.getUnitPrice());
	   row.createCell(2).setCellValue(product.getDescription());
	   row.createCell(3).setCellValue(product.getProduct());
	   row.createCell(4).setCellValue(product.getLocation());
	   row.createCell(5).setCellValue(product.getWeight());
	   row.createCell(6).setCellValue(product.getContact());
	   row.createCell(7).setCellValue(product.getQuantity());

	  }
	  
	 }
	
}
