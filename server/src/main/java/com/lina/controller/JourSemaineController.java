package com.lina.controller;

import com.lina.service.JourSemaineService;
import com.lina.service.Response;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("joursemaine")
@CrossOrigin(origins = "*")
public class JourSemaineController {
	@GetMapping(value="")
	public Response getJourSemaine() {
		return JourSemaineService.getJourSemaine();
	}
	
}
