package com.lina.model;

public class Categorie {
	private int idCategorie;
	private String nomCategorie;
	private double nbHeureN;
	private double salaireHN;
	private double indamnite;

	public Categorie(int idCategorie, String nomCategorie, double nbHeureN, double salaireHN, double indamnite) {
		this.setIdCategorie(idCategorie);
		this.setNomCategorie(nomCategorie);
		this.setNbHeureN(nbHeureN);
		this.setSalaireHN(salaireHN);
		this.setIndamnite(indamnite);
	}

	public Categorie( String nomCategorie, double nbHeureN, double salaireHN, double indamnite) {
		this.setNomCategorie(nomCategorie);
		this.setNbHeureN(nbHeureN);
		this.setSalaireHN(salaireHN);
		this.setIndamnite(indamnite);
	}


	public Categorie() {
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public double getIndamnite() {
		return indamnite;
	}

	public double getNbHeureN() {
		return nbHeureN;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public double getSalaireHN() {
		return salaireHN;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public void setIndamnite(double indamnite) {
		this.indamnite = indamnite;
	}

	public void setNbHeureN(double nbHeureN) {
		this.nbHeureN = nbHeureN;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public void setSalaireHN(double salaireHN) {
		this.salaireHN = salaireHN;
	}
}
