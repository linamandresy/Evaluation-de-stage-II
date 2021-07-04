package com.lina.model;

import java.sql.Date;

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
}
