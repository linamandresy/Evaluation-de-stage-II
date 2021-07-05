package com.lina.model;

public class Majoration {
	private int idMajoration;
	private String nomMaj;
	private double pourcentage;

	public Majoration(String nomMaj, double pourcentage) {
		this.nomMaj = nomMaj;
		this.pourcentage = pourcentage;
	}

	public Majoration(int idMajoration, String nomMaj, double pourcentage) {
		this.idMajoration = idMajoration;
		this.nomMaj = nomMaj;
		this.pourcentage = pourcentage;
	}

	public Majoration() {
	}

	public int getIdMajoration() {
		return idMajoration;
	}

	public String getNomMaj() {
		return nomMaj;
	}

	public double getPourcentage() {
		return pourcentage;
	}

	public void setIdMajoration(int idMajoration) {
		this.idMajoration = idMajoration;
	}

	public void setNomMaj(String nomMaj) {
		this.nomMaj = nomMaj;
	}

	public void setPourcentage(double pourcentage) {
		this.pourcentage = pourcentage;
	}
}