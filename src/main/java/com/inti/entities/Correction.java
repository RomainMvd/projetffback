package com.inti.entities;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Correction implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCorrection;
	private Double noteExamen;
	private String commentaireEnseignant;
	private String nomMatiere; // A RETIRER ???!!!
	@Lob
	private byte[] fichierCorrection;
	
	@OneToOne
	@JoinColumn(name = "id_examen")
	private Examen examen;

	public Correction(Double noteExamen, String commentaireEnseignant, String nomMatiere, byte[] fichierCorrection,
			Examen examen) {
		
		this.noteExamen = noteExamen;
		this.commentaireEnseignant = commentaireEnseignant;
		this.nomMatiere = nomMatiere;
		this.fichierCorrection = fichierCorrection;
		this.examen = examen;
	}

	public Correction(Double noteExamen, String commentaireEnseignant, String nomMatiere, byte[] fichierCorrection) {
		
		this.noteExamen = noteExamen;
		this.commentaireEnseignant = commentaireEnseignant;
		this.nomMatiere = nomMatiere;
		this.fichierCorrection = fichierCorrection;
	}

	public Correction() {
		
	}

	public Long getIdCorrection() {
		return idCorrection;
	}

	public void setIdCorrection(Long idCorrection) {
		this.idCorrection = idCorrection;
	}

	public Double getNoteExamen() {
		return noteExamen;
	}

	public void setNoteExamen(Double noteExamen) {
		this.noteExamen = noteExamen;
	}

	public String getCommentaireEnseignant() {
		return commentaireEnseignant;
	}

	public void setCommentaireEnseignant(String commentaireEnseignant) {
		this.commentaireEnseignant = commentaireEnseignant;
	}

	public String getNomMatiere() {
		return nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}

	public byte[] getFichierCorrection() {
		return fichierCorrection;
	}

	public void setFichierCorrection(byte[] fichierCorrection) {
		this.fichierCorrection = fichierCorrection;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	@Override
	public String toString() {
		return "Correction [idCorrection=" + idCorrection + ", noteExamen=" + noteExamen + ", commentaireEnseignant="
				+ commentaireEnseignant + ", nomMatiere=" + nomMatiere + ", fichierCorrection="
				+ Arrays.toString(fichierCorrection) + ", examen=" + examen + "]";
	}
	
	
}
