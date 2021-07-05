package com.lina.model;

public class HeureSup {
	private int idHeureSup;
	private String nomHS;
	private int nbHeure;
	private int idHSPrec;
	private double pourcentage;

	public HeureSup(String nomHS, int nbHeure, int idHSPrec, double pourcentage) {
		this.nomHS = nomHS;
		this.nbHeure = nbHeure;
		this.idHSPrec = idHSPrec;
		this.pourcentage = pourcentage;
	}

	public HeureSup(int idHeureSup, String nomHS, int nbHeure, int idHSPrec, double pourcentage) {
		this.idHeureSup = idHeureSup;
		this.nomHS = nomHS;
		this.nbHeure = nbHeure;
		this.idHSPrec = idHSPrec;
		this.pourcentage = pourcentage;
	}

	public double getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(double pourcentage) {
		this.pourcentage = pourcentage;
	}

	public HeureSup() {
	}

	public String getNomHS() {
		return nomHS;
	}

	public void setNomHS(String nomHS) {
		this.nomHS = nomHS;
	}

	public int getIdHSPrec() {
		return idHSPrec;
	}

	public int getIdHeureSup() {
		return idHeureSup;
	}

	public int getNbHeure() {
		return nbHeure;
	}

	public void setIdHSPrec(int idHSPrec) {
		this.idHSPrec = idHSPrec;
	}

	public void setIdHeureSup(int idHeureSup) {
		this.idHeureSup = idHeureSup;
	}

	public void setNbHeure(int nbHeure) {
		this.nbHeure = nbHeure;
	}
}
