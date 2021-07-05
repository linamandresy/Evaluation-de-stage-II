package com.lina.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lina.model.dao.DBConnect;

public class Employe {
	private int idEmploye;
	private String nom;
	private String prenom;
	private String matricule;
	private Date naissance;
	private Date embauche;
	private Date finContrat;
	private int idCategorie;

	public Employe(String nom, String prenom, String matricule, Date naissance, Date embauche,
	Date finContrat, int idCategorie) {
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setMatricule(matricule);
		this.setNaissance(naissance);
		this.setEmbauche(embauche);
		this.setFinContrat(finContrat);
		this.setIdCategorie(idCategorie);
}

	public Employe(int idEmploye, String nom, String prenom, String matricule, Date naissance, Date embauche,
			Date finContrat, int idCategorie) {
		this.setIdEmploye(idEmploye);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setMatricule(matricule);
		this.setNaissance(naissance);
		this.setEmbauche(embauche);
		this.setFinContrat(finContrat);
		this.setIdCategorie(idCategorie);
	}

	public Employe() {
	}

	public void setEmbauche(Date embauche) {
		this.embauche = embauche;
	}

	public void setFinContrat(Date finContrat) {
		this.finContrat = finContrat;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getEmbauche() {
		return embauche;
	}

	public Date getFinContrat() {
		return finContrat;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public int getIdEmploye() {
		return idEmploye;
	}

	public String getMatricule() {
		return matricule;
	}

	public Date getNaissance() {
		return naissance;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
	public static  Employe findById(Connection c,int id)throws Exception{
		String sql="SELECT idemploye,nom,prenom,matricule,naissance,embauche,fincontrat,idCategorie FROM EMPLOYE WHERE IDEMPLOYE=?";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setInt(1,id);
		ResultSet rs = null;
		try {
			rs = pst.executeQuery();
			if(rs.next()){
				return new Employe(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getDate(6), rs.getDate(7), rs.getInt(8));
			}
			throw new Exception("Employé inexistant");
		} catch (Exception e) {
			throw e;
		}finally{
			if(rs!=null) rs.close();
		}
	}
	public static Employe findById(int id)throws Exception{
		Connection c = null;
		try{
			c = DBConnect.getDAO().connect();
			return findById(c, id);
		}catch(Exception ex){
			throw ex;
		}finally{
			if(c!=null) c.close();
		}
	}
}
