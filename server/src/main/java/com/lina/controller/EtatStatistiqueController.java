package com.lina.controller;

import com.lina.service.EtatStatistiqueService;
import com.lina.service.Response;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("statistique")
@CrossOrigin(origins = "*")
public class EtatStatistiqueController {
	@GetMapping(value="")
	public Response get() {
		return EtatStatistiqueService.get();
	}
	
}
