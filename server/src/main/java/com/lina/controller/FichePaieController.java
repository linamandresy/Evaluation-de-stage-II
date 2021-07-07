package com.lina.controller;

import com.lina.service.FichePaieService;
import com.lina.service.Response;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("fichepaie")
@CrossOrigin(origins="*")
public class FichePaieController {
	@GetMapping(value="/{id}")
	public Response getFiche(@PathVariable int id) throws Exception{
		return FichePaieService.findById(id);
	}	
}
