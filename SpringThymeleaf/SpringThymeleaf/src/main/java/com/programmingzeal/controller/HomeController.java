package com.programmingzeal.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	private static final Logger LOGGER = Logger.getLogger(HomeController.class);

	@RequestMapping(value = "/")
	public String index() {

		return "index";
	}

	@RequestMapping(value = "/list")

	public String getList(Model m) {

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		m.addAttribute("list", list);

		return "list";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Model m, @RequestParam String name, @RequestParam String course) {
		m.addAttribute("name", name);
		m.addAttribute("course", course);

		return "index";
	}
}
