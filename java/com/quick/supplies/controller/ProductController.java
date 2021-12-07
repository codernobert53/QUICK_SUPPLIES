package com.quick.supplies.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import com.quick.supplies.domain.Product;
import com.quick.supplies.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	 private ProductService productService;
	
	@RequestMapping("/products")
	 public String list(Model model) {
		model.addAttribute("products",
		productService.getAllProducts());
		return "products";
	 }
	
	//@RequestMapping("/{category}")
	 //public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) { model.addAttribute("products",
	 //productService.getProductsByCategory(productCategory));
	 //return "products";
	// }
	
	//@RequestMapping("/update/stock")
	 //public String updateStock(Model model) {
	 //productService.updateAllStock();
	 //return "redirect:/products";
	 //}
	
	//insert
	@RequestMapping(value = "/products/add", method = RequestMethod.GET)
	   public String getAddNewProductForm(Model model) {
	   Product newProduct = new Product();
	   model.addAttribute("newProduct", newProduct);
	   return "addProduct";
	}
	
	@RequestMapping(value = "/products/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct")  Product newProduct, HttpServletRequest request) {
      
		MultipartFile productManual = newProduct.getProductManual();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		 if (productManual!=null && !productManual.isEmpty()) {
		   try {
		         productManual.transferTo(new File(rootDirectory+"resources/pdf/"+ newProduct.getProductId() + ".pdf"));
		       } catch (Exception e) {
		             throw new RuntimeException("Product Manual saving failed", e);
		         }
		 }	
		
		 MultipartFile productImage = newProduct.getProductImage();
			String rootDirectory2 = request.getSession().getServletContext().getRealPath("/");
			 if (productImage!=null && !productImage.isEmpty()) {
			   try {
			         productImage.transferTo(new File(rootDirectory2+"resources/images/"+ newProduct.getProductId() + ".jpg"));
			       } catch (Exception e) {
			             throw new RuntimeException("Product Image saving failed", e);
			         }
			 }
		 
	  productService.addProduct(newProduct);
	  return "redirect:/editProducts";
	}
	
	
		
	
	
}
