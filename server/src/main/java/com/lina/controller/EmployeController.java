package com.lina.controller;

import com.lina.service.EmployeService;
import com.lina.service.Response;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("employe")
public class EmployeController {
	@GetMapping(value="")
	public Response getListEmploye() throws Exception{
		return EmployeService.getListEmploye();
	}
	
}
