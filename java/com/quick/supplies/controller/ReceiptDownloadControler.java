package com.quick.supplies.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.quick.supplies.domain.OrdersMade;
import com.quick.supplies.domain.Supplier;
import com.quick.supplies.service.AdminService;
import com.quick.supplies.service.SupplierService;
import com.quick.supplies.view.DownloadOrdersExcel;
import com.quick.supplies.view.DownloadOrdersPdf;
import com.quick.supplies.view.DownloadReceipt;
import com.quick.supplies.view.DownloadSuppliersExcel;
import com.quick.supplies.view.DownloadSuppliersPdf;

@Controller
@RequestMapping(value="/")
public class ReceiptDownloadControler {
	
	@Autowired
	 private SupplierService suppplierService;
	
	@Autowired
	 private AdminService adminService;
	
	@RequestMapping(value="/receiptDownload", method=RequestMethod.GET)
	 public ModelAndView productLisbbtReport(HttpServletRequest req, HttpServletResponse res){

	  String typeReport = req.getParameter("type");
	  
	  List <OrdersMade> list = adminService.getAllOrdersMade();
	  
	  if(typeReport != null && typeReport.equals("pdf")){
	   return new ModelAndView(new DownloadReceipt(), "receiptList" , list);
	  }
	  
	  return new ModelAndView("receipt", "receiptList", list);
	 }
	
	@RequestMapping(value="/orders_report", method=RequestMethod.GET)
	 public ModelAndView ordersListReport(HttpServletRequest req, HttpServletResponse res){

		String typeReport = req.getParameter("type");
		  
		  List<OrdersMade> list = adminService.getAllOrdersMade();
		  
		  if(typeReport != null && typeReport.equals("xls")){
			   return new ModelAndView(new DownloadOrdersExcel(), "ordersList", list);
			  } else if(typeReport != null && typeReport.equals("pdf")){
			   return new ModelAndView(new DownloadOrdersPdf(), "ordersList", list);
			  }
			  
			  return new ModelAndView("ordersListReport", "ordersList", list);
		  
	 }
	
	@RequestMapping(value="/supplier_report", method=RequestMethod.GET)
	 public ModelAndView suppliersListReport(HttpServletRequest req, HttpServletResponse res){

		String typeReport = req.getParameter("type");
		  
		  List<Supplier> list = suppplierService.getAllSuppliers();
		  
		  if(typeReport != null && typeReport.equals("xls")){
			   return new ModelAndView(new DownloadSuppliersExcel(), "suppliersList", list);
			  } else if(typeReport != null && typeReport.equals("pdf")){
			   return new ModelAndView(new DownloadSuppliersPdf(), "suppliersList", list);
			  }
			  
			  return new ModelAndView("suppliersListReport", "suppliersList", list);
		  
	 }
	
}
