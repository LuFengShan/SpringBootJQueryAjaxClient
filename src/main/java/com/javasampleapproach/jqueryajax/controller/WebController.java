package com.javasampleapproach.jqueryajax.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@Slf4j
@Controller
public class WebController {

	@GetMapping(value = "/")
	public String homepage() {
		return "index";
	}

	@GetMapping(value = "/h2")
	public String homepage2() {
		return "index2";
	}

	@ResponseBody
	@GetMapping("/test")
	public String test(@RequestParam(required = false) String param) {
		String vals = vals(param);
		return vals;
	}

	@ResponseBody
	@GetMapping({"/test100", "/test100/{param}"})
	public String test1(@PathVariable(required = false) String param) {
		String vals = vals(param);
		return vals;
	}

	private String vals(String param) {
		if (Objects.isNull(param))
			return "kong";
		return param;
	}
}