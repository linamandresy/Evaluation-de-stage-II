package com.lina.model.dao;

import java.util.ResourceBundle;

public class DBConnect {
	public static DAOLina dao;
	static ResourceBundle resource = ResourceBundle.getBundle("application");
	public static DAOLina getDAO(){
		if(dao==null){
			String uri = resource.getString("spring.datasource.url");
			String username = resource.getString("spring.datasource.username");
			String password = resource.getString("spring.datasource.password");
			dao = new DAOLina("org.postgresql.Driver", uri, username, password);
		}
		return dao;
	}
}
