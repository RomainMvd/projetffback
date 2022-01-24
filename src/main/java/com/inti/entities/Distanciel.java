package com.inti.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("distanciel")
public class Distanciel extends Cours implements Serializable{
	
	private String lienZoom;

	public Distanciel(String lienZoom) {
		super();
		this.lienZoom = lienZoom;
	}

	public Distanciel(String nomCours, String nomMatiere, Double nbrHeure, byte[] fichierCours, String lienZoom) {
		super(nomCours, nomMatiere, nbrHeure, fichierCours);
		this.lienZoom = lienZoom;
	}

	public String getLienZoom() {
		return lienZoom;
	}

	public void setLienZoom(String lienZoom) {
		this.lienZoom = lienZoom;
	}
	
	public Distanciel() {}

}
