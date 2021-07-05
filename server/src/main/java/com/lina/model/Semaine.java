package com.lina.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.lina.model.dao.DBConnect;

public class Semaine {
	private int idSemaine;
	private String noSemaine;

	public Semaine(String noSemaine) {
		this.noSemaine = noSemaine;
	}

	public Semaine(int idSemaine, String noSemaine) {
		this.idSemaine = idSemaine;
		this.noSemaine = noSemaine;
	}

	public Semaine() {
	}

	public int getIdSemaine() {
		return idSemaine;
	}

	public String getNoSemaine() {
		return noSemaine;
	}

	public void setIdSemaine(int idSemaine) {
		this.idSemaine = idSemaine;
	}

	public void setNoSemaine(String noSemaine) {
		this.noSemaine = noSemaine;
	}
	public static void insertNewSemaine(Connection c)throws Exception{
		String sql="insert into semaine(nosemaine) values('Semaine '||nextval('sq_semaine'))";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.execute();
	}
	public static void insertNewSemaine()throws Exception{
		Connection c = null;
		try{
			c = DBConnect.getDAO().connect();
			insertNewSemaine(c);
			c.commit();
		}catch(Exception ex){
			if(c!=null) c.rollback();
			throw ex;
		}finally{
			if(c!=null) c.close();
		}
	}	
}
