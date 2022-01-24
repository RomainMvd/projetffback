package com.inti.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("enseignant")
public class Enseignant extends Personne implements Serializable{
	
	private Double salaire;

	public Enseignant() {}
	
	public Enseignant(Double salaire) {
		super();
		this.salaire = salaire;
	}

	public Enseignant(String nomPersonne, String prenomPersonne, Date dateNaissancePersonne, String username,
			String password, String email, boolean enabled, byte[] photoProfil, Double salaire) {
		super(nomPersonne, prenomPersonne, dateNaissancePersonne, username, password, email, enabled, photoProfil);
		this.salaire = salaire;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
}
