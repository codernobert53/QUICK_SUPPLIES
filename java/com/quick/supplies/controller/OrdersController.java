package com.quick.supplies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quick.supplies.service.AdminService;

@Controller
public class OrdersController {

	@Autowired
	 private AdminService adminService;
	
	//Read
		@RequestMapping("/editDeliveryStatus")
		public String editOrders_Made(Model model) {
		model.addAttribute("editDeliveryStatus",adminService.getAllOrdersMade());
		return "editDeliveryStatus";
		}
		
		
	
		@RequestMapping("/Orders_Made")
		public String OrdersMade(Model model) {
			model.addAttribute("Orders_Made",adminService.getAllOrdersMade());
			return "Orders_Made";
		}
		
		@RequestMapping("/orders")
		public String Orders(Model model) {
			model.addAttribute("orders",adminService.getAllOrdersMade());
			return "orders";
		}
		
		@RequestMapping("/Delivered_Orders")
		public String AllDeliveredOrders(Model model) {
			model.addAttribute("Delivered_Orders",adminService.getAllDeliveredOrders());
			return "Delivered_Orders";
		}
		
		@RequestMapping("/chart")
		public String Chart(Model model) {
			model.addAttribute("chart",adminService.getAllOrdersMade());
			return "chart";
		}
		
		@RequestMapping(value = "/receipt", method = RequestMethod.GET)
		 public String getOrderById(@RequestParam("productId") String productId, Model model) {
			model.addAttribute("receipt",adminService.getOrderById(productId));
		    return "receipt";
		 }
		
}
