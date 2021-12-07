package com.quick.supplies.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.quick.supplies.domain.Farmer;
import com.quick.supplies.domain.Product;
import com.quick.supplies.service.AdminService;
import com.quick.supplies.service.FarmerService;
import com.quick.supplies.service.ProductService;

@Controller
public class FarmerController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	 private FarmerService farmerService;
	
	@Autowired
	 private AdminService adminService;
	
	//READ
	@RequestMapping("/editProducts")
	public String editProducts1(Model model) {
	model.addAttribute("editProducts",productService.getAllProducts());
	return "editProducts";
	}
	
	//READ
	@RequestMapping("/viewPriceTrends")
	public String viewPriceTrends(Model model, HttpServletRequest req, HttpServletResponse res) {
	model.addAttribute("viewPriceTrends",adminService.getAllPriceTrends());
	
	return "viewPriceTrends";
	}
	
	@RequestMapping("/SupplierDashboard")
	public String SupplierDashboard(Model model) {
	return "SupplierDashboard";
	}
	
	//INSERT
	@RequestMapping(value = "/farmer/register", method = RequestMethod.GET)
	   public String getAddNewProductForm(Model model) {
	   Farmer newFarmer = new Farmer();
	   model.addAttribute("newFarmer", newFarmer);
	   return "farmer_registration";
	}
	
	@RequestMapping(value = "/farmer/register", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct")  Farmer newFarmer) {	
		
	  farmerService.registerFarmer(newFarmer);
	  return "redirect:/farmer/register";
	}
	
	//UPDATE
	@RequestMapping(value="/update/{proId}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("proId") int proId){
	  ModelAndView model = new ModelAndView("product_updateForm");
	  
	  Product product = productService.findProduct(proId);
	  model.addObject("productForm", product);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("productForm") Product product){
		 productService.updateProduct(product);
	  return new ModelAndView("redirect:/editProducts");
	 }
     
	 //DELETE
	 @RequestMapping(value="/delete/{proId}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("proId") int proId){
		 productService.deleteProduct(proId);
	  
	  return new ModelAndView("redirect:/editProducts");
	 }
	  
	 
	
}
