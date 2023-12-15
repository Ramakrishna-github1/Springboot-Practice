package com.cts.dev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping(path = "/getGreetings")
	public String getStrings() {
		return "Welcome to springboot";
	}
}
