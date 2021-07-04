package com.lina.controller;

import com.lina.service.Response;
import com.lina.service.UtilisateurService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("utilisateur")
@CrossOrigin(origins="*")
public class UtilisateurController {
	@PostMapping(value="login")
	public Response postLogin(String logins,String passwords) throws Exception{
		return UtilisateurService.authentificate(logins, passwords);
	}
}
