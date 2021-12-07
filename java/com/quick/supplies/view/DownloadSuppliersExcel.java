package com.quick.supplies.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.quick.supplies.domain.Supplier;

public class DownloadSuppliersExcel extends AbstractXlsView{
	@Override
	 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
	   HttpServletResponse response) throws Exception {
	  
	  response.setHeader("Content-disposition", "attachment; filename=\"suppliers.xls\"");
	  
	  @SuppressWarnings("unchecked")
	  List <Supplier> list = (List<Supplier>) model.get("suppliersList");
	  
	  Sheet sheet = workbook.createSheet("User List");
	  
	  Row header = sheet.createRow(0);
	  header.createCell(0).setCellValue("name");
	  header.createCell(1).setCellValue("contact");
	  header.createCell(1).setCellValue("address");
 
	  int rowNum = 1;
	  
	  for(Supplier supplier : list){
	   Row row = sheet.createRow(rowNum++);
	   
	   row.createCell(0).setCellValue(supplier.getName());
	   row.createCell(1).setCellValue(supplier.getContact());
	   row.createCell(2).setCellValue(supplier.getAddress());


	  }
	  
	 }
}
