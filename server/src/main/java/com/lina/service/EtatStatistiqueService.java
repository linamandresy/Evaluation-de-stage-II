package com.lina.service;

import com.lina.model.label.EtatStatistique;

public class EtatStatistiqueService {
	public static Response get(){
		try {
			return new Response(200,EtatStatistique.get());
		} catch (Exception e) {
			return new Response(400,e.getMessage());
		}
	}
}
