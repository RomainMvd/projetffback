package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Evaluation implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvaluation;
	private String commentaire;
	private Double noteCours;

	@ManyToOne
	@JoinColumn(name = "id_cours")
	private Cours cours;

	public Evaluation(String commentaire, Double noteCours) {
		this.commentaire = commentaire;
		this.noteCours = noteCours;
	}

	public Evaluation() {

	}

	public Evaluation(String commentaire, Double noteCours, Cours cours) {
		this.commentaire = commentaire;
		this.noteCours = noteCours;
		this.cours = cours;
	}

	public Long getIdEvaluation() {
		return idEvaluation;
	}

	public void setIdEvaluation(Long idEvaluation) {
		this.idEvaluation = idEvaluation;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Double getNoteCours() {
		return noteCours;
	}

	public void setNoteCours(Double noteCours) {
		this.noteCours = noteCours;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	@Override
	public String toString() {
		return "Evaluation [idEvaluation=" + idEvaluation + ", commentaire=" + commentaire + ", noteCours=" + noteCours
				+ ", cours=" + cours + "]";
	}

	
}
