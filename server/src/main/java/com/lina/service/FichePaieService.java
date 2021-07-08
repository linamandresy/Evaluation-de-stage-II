package com.lina.service;

import javax.servlet.http.HttpServletResponse;

import com.lina.model.label.FichePaie;

public class FichePaieService {
	public static Response findById(int id)throws Exception{
		try{
			return new Response(200,FichePaie.findById(id));
		}catch(Exception ex){
			return new Response(400,ex.getMessage());
		}
	}
}
