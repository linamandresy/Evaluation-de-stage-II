package com.lina.controller;

import com.lina.service.MajorationService;
import com.lina.service.Response;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("majoration")
@CrossOrigin(origins = "*")
public class MajorationController {
	@GetMapping(value="")
	public Response getMajoration() {
		return MajorationService.getMajoration();
	}
	
}
