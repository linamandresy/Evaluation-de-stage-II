package com.lina.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Index
 */
@RestController
public class Index {
	@GetMapping(value="")
	public String get() {
		return "Hello World";
	}
	
	
}