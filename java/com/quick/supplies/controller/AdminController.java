package com.quick.supplies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quick.supplies.domain.Admin;
import com.quick.supplies.service.AdminService;
import com.quick.supplies.service.ProductService;

@Controller
public class AdminController {

	@Autowired
	 private AdminService adminService;
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping("/AdminDashboard")
	public String AdminDashboard(Model model) {
		model.addAttribute("AdminDashboard",adminService.getAllOrdersMade());
		model.addAttribute("AdminDashboard",productService.getAllProducts());
	return "AdminDashboard";
	}
	
	@RequestMapping("/barchart")
	public String barchart1(Model model) {
		
	return "barchart";
	}
	
	//Read
	@RequestMapping("/editPriceTrends")
	public String editPriceTrends(Model model) {
	model.addAttribute("editPriceTrends",adminService.getAllPriceTrends());
	return "editPriceTrends";
	}
	
	@RequestMapping("/makeOrders")
	public String makeOrders1(Model model) {
	model.addAttribute("makeOrders",productService.getAllProducts());
	return "makeOrders";
	}
	
	//insert price trend
	@RequestMapping(value = "/add/PriceTrend", method = RequestMethod.GET)
	   public String getAddNewPriceTrend(Model model) {
	  Admin newPriceTrend = new Admin();
	   model.addAttribute("newPriceTrend", newPriceTrend);
	   return "addPriceTrend";
	}
	
	@RequestMapping(value = "/add/PriceTrend", method = RequestMethod.POST)
	public String processAddNewPriceTrend(@ModelAttribute("newPriceTrend")  Admin newPriceTrend) {	
		
		adminService.addPriceTrends(newPriceTrend);
	  return "redirect:/add/PriceTrend";
	}
	
	//insert order
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	   public String getAddNewOrder(@RequestParam("id") String productId, Model model) {
	   Admin newOrder = new Admin();
	   model.addAttribute("newOrder", newOrder);
	   model.addAttribute("product", productService.getProductById(productId));
	   return "product";
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String processAddNewOrder(@ModelAttribute("newOrder")  Admin newOrder) {	
		adminService.addOrder(newOrder);
	  return "redirect:/Orders_Made";
	}
	
	//@RequestMapping("/product")
	 //public String getProductById(@RequestParam("id") String productId, Model model) {
		//model.addAttribute("product", 
	    //productService.getProductById(productId));
	    //return "product";
	 //}
	
	//update
	@RequestMapping(value="/updatePriceTrend/{priceTrend_id}", method=RequestMethod.GET)
	 public ModelAndView updatePriceTrend(@PathVariable("priceTrend_id") int priceTrend_id){
	  ModelAndView model = new ModelAndView("price_Trend_Update_Form");  
	  Admin admin  = adminService.findPriceTrendsById(priceTrend_id);
	  model.addObject("priceTrendForm", admin);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/savePriceTrend", method=RequestMethod.POST)
	 public ModelAndView savePriceTrend(@ModelAttribute("priceTrendForm") Admin admin){
		 adminService.updatePriceTrends(admin);
	  return new ModelAndView("redirect:/editPriceTrends");
	 }
	 
	//delete
	 @RequestMapping(value="/deletePriceTrend/{priceTrend_id}", method=RequestMethod.GET)
	 public ModelAndView deletePriceTrend(@PathVariable("priceTrend_id") int priceTrend_id){
		 adminService.deletePriceTrends(priceTrend_id);
	  
	  return new ModelAndView("redirect:/editPriceTrends");
	 }
	 
	//delete order
	 @RequestMapping(value="/deleteOrder/{orderId}", method=RequestMethod.GET)
	 public ModelAndView deleteOrder(@PathVariable("orderId") int orderId){
		 adminService.deleteOrder(orderId);
	  
	  return new ModelAndView("redirect:/Orders_Made");
	 }
	 
}
