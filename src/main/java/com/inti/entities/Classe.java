package com.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Classe implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idClasse;
    @Column(unique=true)
    private String nomClasse;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PersonneClasse", joinColumns = @JoinColumn(name = "id_classe", referencedColumnName = "idClasse"), inverseJoinColumns = @JoinColumn(name = "id_personne", referencedColumnName = "idPersonne"))
    private Set<Personne> personnes = new HashSet<>();
    
    public Classe(String nomClasse) {
        this.nomClasse = nomClasse;
    }
    
    public Classe() {
    }

    public Classe(String nomClasse, Set<Personne> personnes) {
        this.nomClasse = nomClasse;
        this.personnes = personnes;
    }

    public Long getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Long idClasse) {
        this.idClasse = idClasse;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }
    
    public Set<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(Set<Personne> personnes) {
        this.personnes = personnes;
    }

    @Override
    public String toString() {
        return "Classe [idClasse=" + idClasse + ", nomClasse=" + nomClasse + "]";
    }
    
    
}
