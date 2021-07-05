package com.lina.service;

import com.lina.model.Majoration;
import com.lina.model.dao.DBConnect;

public class MajorationService {
	public static Response getMajoration(){
		try {
			return new Response(200,DBConnect.getDAO().find(Majoration.class));
		} catch (Exception e) {
			return new Response(400,e.getMessage());
		}
	}
}
