package com.quick.supplies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.quick.supplies.domain.Supplier;
import com.quick.supplies.service.SupplierService;

@Controller
public class SupplierController {
	@Autowired
	 private SupplierService suppplierService;
	
	@RequestMapping("/suppliers")
	 public String list(Model model) {
		model.addAttribute("suppliers",suppplierService.getAllSuppliers());
		return "suppliers";
	 }
	
	@RequestMapping(value = "/add/supplier", method = RequestMethod.GET)
	   public String getAddNewSupplier(Model model) {
	   Supplier newSupplier = new Supplier();
	   model.addAttribute("newSupplier", newSupplier);
	   return "addSupplier";
	}
	
	@RequestMapping(value = "/add/supplier", method = RequestMethod.POST)
	public String processAddNewSupplier(@ModelAttribute("newSupplier")  Supplier newSupplier) {	
		
		suppplierService.addSupplier(newSupplier);
	  return "redirect:/suppliers";
	}
	
	@RequestMapping(value="/updateSupplier/{supplier_Id}", method=RequestMethod.GET)
	 public ModelAndView updatePriceTrend(@PathVariable("supplier_Id") int supplier_Id){
	  ModelAndView model = new ModelAndView("supplier_Update_Form");  
	  Supplier supplier  = suppplierService.findSupplierById(supplier_Id);
	  model.addObject("supplierForm", supplier);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/saveSupplier", method=RequestMethod.POST)
	 public ModelAndView savePriceTrend(@ModelAttribute("supplierForm") Supplier supplier){
		 suppplierService.updateSupplierDetails(supplier);;
	  return new ModelAndView("redirect:/suppliers");
	 }
	 
	//delete
	 @RequestMapping(value="/deleteSupplier/{supplier_Id}", method=RequestMethod.GET)
	 public ModelAndView deletePriceTrend(@PathVariable("supplier_Id") int supplier_Id){
		 suppplierService.deleteSupplierDetails(supplier_Id);
	  
	  return new ModelAndView("redirect:/suppliers");
	 }
	
}
