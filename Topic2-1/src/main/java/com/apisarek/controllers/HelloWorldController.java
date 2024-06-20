package com.apisarek.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@GetMapping("/test1")
	@ResponseBody
	public String printHello() {
		return "Helllo World";
	}
	
	@GetMapping("/test2")
	public String showPrintHello(Model model) {
		model.addAttribute("message", "Have a greate day!!!");
		return "Hello";
	}
	
	@GetMapping("/test3")
	public ModelAndView printHelloAgain() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "Have super day...");
		mv.addObject("rating", 55);
		mv.setViewName("Hello");
		return mv;
		
	}
}
