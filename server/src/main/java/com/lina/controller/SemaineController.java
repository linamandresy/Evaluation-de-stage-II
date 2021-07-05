package com.lina.controller;

import com.lina.service.Response;
import com.lina.service.SemaineService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("semaine")
@CrossOrigin(origins = "*")
public class SemaineController {
	@PostMapping(value="")
	public Response postSemaine(@RequestHeader(name="Authorization")String token) throws Exception{
		return SemaineService.nouvelleSemaine(token);
	}
	@GetMapping(value="")
	public Response getSemaine() {
		return SemaineService.getSemaines();
	}
		
}
