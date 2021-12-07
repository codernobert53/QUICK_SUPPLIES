package com.quick.supplies.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.quick.supplies.domain.OrdersMade;

public class DownloadOrdersExcel extends AbstractXlsView{
	@Override
	 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
	   HttpServletResponse response) throws Exception {
	  
	  response.setHeader("Content-disposition", "attachment; filename=\"orders.xls\"");
	  
	  @SuppressWarnings("unchecked")
	  List<OrdersMade> list = (List<OrdersMade>) model.get("ordersList");
	  
	  Sheet sheet = workbook.createSheet("User List");
	  
	  Row header = sheet.createRow(0);
	  header.createCell(0).setCellValue("productId");
	  header.createCell(1).setCellValue("owner");
	  header.createCell(2).setCellValue("contact");
	  header.createCell(3).setCellValue("product");
	  header.createCell(4).setCellValue("weight");
	  header.createCell(5).setCellValue("quantity");
	  header.createCell(6).setCellValue("unitPrice");
	  header.createCell(7).setCellValue("quantity");

	  
	  int rowNum = 1;
	  
	  for(OrdersMade ordersMade : list){
	   Row row = sheet.createRow(rowNum++);
	   
	   row.createCell(0).setCellValue(ordersMade.getProductId());
	   row.createCell(1).setCellValue(ordersMade.getOwner());
	   row.createCell(1).setCellValue(ordersMade.getContact());
	   row.createCell(2).setCellValue(ordersMade.getProduct());
	   row.createCell(3).setCellValue(ordersMade.getWeight());
	   row.createCell(4).setCellValue(ordersMade.getQuantity());
	   row.createCell(5).setCellValue(ordersMade.getUnitPrice());
	   row.createCell(6).setCellValue(ordersMade.getDescription());

	  }
	  
	 }
}
