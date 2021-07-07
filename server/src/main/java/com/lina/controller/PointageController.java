package com.lina.controller;

import com.lina.helper.Jour7;
import com.lina.model.Pointage;
import com.lina.service.PointageService;
import com.lina.service.Response;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping("pointage")
@CrossOrigin(origins="*")
public class PointageController {
	@PostMapping(value="")
	public Response postPointage(@RequestHeader(name="Authorization")String token,@RequestBody Jour7 j) throws Exception{
		return PointageService.insertPointage(token, j);
	}
	
}
