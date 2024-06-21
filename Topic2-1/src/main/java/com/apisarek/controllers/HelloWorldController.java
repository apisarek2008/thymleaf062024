package com.apisarek.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.apisarek.models.Person;

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

	@GetMapping("/test4")
	public String showPrintHello4(@RequestParam("message") String message, Model model) {
		model.addAttribute("message", message);
		return "Hello";
	}

	@GetMapping("/people")
	public String showFriends(Model model) {
		
		List<Person> friends = new ArrayList<Person>();
		
		friends.add(new Person (1, "Allan", 23, 56.4f));
		friends.add(new Person (2, "Zenek", 45, 57.4f));
		friends.add(new Person (3, "Bob", 14, 54.4f));
		friends.add(new Person (4, "Hans", 65, 23.4f));
		friends.add(new Person (5, "Pinokio", 33, 55.4f));
		
		System.out.println(friends);
		
		model.addAttribute("people", friends);
		return "printFriends.html";
	}
	
	@GetMapping("/peopleJSON")
	@ResponseBody
	public List<Person> showFriendsJSON(Model model) {
		
		List<Person> friends = new ArrayList<Person>();
		
		friends.add(new Person (1, "Allan", 23, 56.4f));
		friends.add(new Person (2, "Zenek", 45, 57.4f));
		friends.add(new Person (3, "Bob", 14, 54.4f));
		friends.add(new Person (4, "Hans", 65, 23.4f));
		friends.add(new Person (5, "Pinokio", 33, 55.4f));
		
		System.out.println(friends);
		
		model.addAttribute("people", friends);
		return friends;
	}

}

































