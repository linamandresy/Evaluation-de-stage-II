package com.lina.controller;

import com.lina.service.Response;
import com.lina.service.UtilisateurService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("utilisateur")
@CrossOrigin(origins="*")
public class UtilisateurController {
	@PostMapping(value="login")
	public Response postLogin(String logins,String passwords) throws Exception{
		return UtilisateurService.authentificate(logins, passwords);
	}
	@GetMapping(value="")
	public Response checkAuthentification(@RequestHeader(name="Authorization")String token) {
		return UtilisateurService.checkValidToken(token);
	}
	
}
