package com.spring.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/springmvc")

// ��ʾSpring MVC����һ��Controller���Լ����ظ��ļ����µ�hello
public class SimpleMvcController {

	@RequestMapping("/home")
	public String helloMvc(Model model) {
		model.addAttribute("greeting", "Hello Spring MVC");
		return "home"; // ����home.jsp
	}

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	@ResponseBody
	public String helloWorld(@RequestParam("user") String userName) {
		return "Hello " + userName + " !";
	}

	@RequestMapping(value = "helloMap", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> helloMap(@RequestParam(value = "user", required = false, defaultValue = "World") String userName) {
		Map<String, String> ret = new HashMap<String, String>();
		ret.put("hello", userName);
		return ret;
	}
}
