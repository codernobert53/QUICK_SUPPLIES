package com.quick.supplies.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.quick.supplies.domain.Product;
import com.quick.supplies.service.ProductService;
import com.quick.supplies.view.ExcelProductListReportView;
import com.quick.supplies.view.PdfProductListReportView;

@Controller
@RequestMapping(value="/")
public class ProductReportController {

	@Autowired
	 private ProductService productService;
	
	 @RequestMapping(value="/products_report", method=RequestMethod.GET)
	 public ModelAndView productListReport(HttpServletRequest req, HttpServletResponse res){

	  String typeReport = req.getParameter("type");
	  
	  List<Product> list = productService.getAllProducts();
	 
	  if(typeReport != null && typeReport.equals("xls")){
	   return new ModelAndView(new ExcelProductListReportView(), "productList", list);
	  } else if(typeReport != null && typeReport.equals("pdf")){
	   return new ModelAndView(new PdfProductListReportView(), "productList", list);
	  }
	  
	  return new ModelAndView("productListReport", "productList", list);
	 }
}
