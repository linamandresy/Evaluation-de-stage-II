package com.lina.controller;

import com.lina.service.MajorationService;
import com.lina.service.Response;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("majoration")
@CrossOrigin(origins = "*")
public class MajorationController {
	@GetMapping(value="")
	public Response getMajoration() {
		return MajorationService.getMajoration();
	}
	@GetMapping(value="/{id}")
	public Response getMethodName(@PathVariable int id) {		
		return MajorationService.getById(id);
	}
	@PutMapping(value="/{id}")
	public Response putMethodName(@PathVariable int id,String nomMaj,double pourcentage) {		
		return MajorationService.updateMajoration(id, nomMaj, pourcentage);
	}
}
