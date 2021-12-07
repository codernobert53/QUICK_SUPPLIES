package com.quick.supplies.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quick.supplies.domain.Delivery;
import com.quick.supplies.service.DeliveryService;

@Controller
public class UpdateController {

	@Autowired
	private DeliveryService deliveryService;

	@RequestMapping(value = "/read")
	public ModelAndView readStudent(ModelAndView model) throws IOException {

		List<Delivery> listDeliveries = deliveryService.read();
		model.addObject("listDeliveries", listDeliveries);
		model.setViewName("read");

		return model;
	}
	
	@RequestMapping("/updateDev")
	public String updateD(Model model) {
	return "updateDev";
	}
	
	@RequestMapping(value = "/updateDev/{orderId}")
	public ModelAndView findStudentById(ModelAndView model, @PathVariable("orderId") int orderId)
			throws IOException {

		List<Delivery> listDeliveries = deliveryService.findOrderById(orderId);
		model.addObject("listDeliveries", listDeliveries);
		model.setViewName("updateDev");

		return model;
	}
	
	@RequestMapping(value = "/updateDev", method = RequestMethod.POST)
	public ModelAndView updateStudent(@RequestParam("orderId") int orderId, @RequestParam("delivery_status") String delivery_status
			 , ModelAndView mv) {

		Delivery delivery = new Delivery();
		delivery.setOrderId(orderId);
		delivery.setDelivery_status(delivery_status);
		

		int counter = deliveryService.update(delivery);

		if (counter > 0) {
			mv.addObject("msg", "Student records updated against student id: " + delivery.getOrderId());
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("redirect:/read");

		return mv;
	}
	
}
