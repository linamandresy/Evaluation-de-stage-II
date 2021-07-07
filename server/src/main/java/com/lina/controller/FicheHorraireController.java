package com.lina.controller;

import com.lina.service.FicheHorraireService;
import com.lina.service.Response;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("fichehorraire")
@CrossOrigin(origins="*")
public class FicheHorraireController {
	@GetMapping(value="/{id}")
	public Response getById(@PathVariable int id) {
		return FicheHorraireService.findById(id);
	}
}
