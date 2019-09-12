package fr.formation.inti.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//@Entity
//@Table(name = "Voiture")
public class Voiture {
	
	private Integer voitureId;
	private String marque;
	private List<Personne> listPers = new ArrayList<Personne>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VOITURE_ID")
	public Integer getVoitureId() {
		return voitureId;
	}
	public void setVoitureId(Integer voitureId) {
		this.voitureId = voitureId;
	}
	
	@Column(name = "MARQUE")
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "Voiture_Personne",
		joinColumns = {@JoinColumn(name = "PERSONNE_ID", nullable = false, updatable = false)}, 
		inverseJoinColumns = {@JoinColumn(name = "VOITURE_ID",nullable = false, updatable = false)})
	public List<Personne> getListPers() {
		return listPers;
	}
	public void setListPers(List<Personne> listPers) {
		this.listPers = listPers;
	}
	
	
	@Override
	public String toString() {
		return "Voiture [voitureId=" + voitureId + ", marque=" + marque + ", listPers=" + listPers + "]";
	}	
}
