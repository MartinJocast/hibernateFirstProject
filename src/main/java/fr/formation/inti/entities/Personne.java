package fr.formation.inti.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//@Entity
//@Table(name = "Personne")
public class Personne {

	private Integer persId;
	private String firstName;
	private String lastName;
	private List<Voiture> listVoit = new ArrayList<Voiture>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERSONNE_ID")
	public Integer getPersId() {
		return persId;
	}
	public void setPersId(Integer persId) {
		this.persId = persId;
	}
	
	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "listPers")
	public List<Voiture> getListVoit() {
		return listVoit;
	}
	public void setListVoit(List<Voiture> listVoit) {
		this.listVoit = listVoit;
	}
	
	@Override
	public String toString() {
		return "Personne [persId=" + persId + ", firstName=" + firstName + ", lastName=" + lastName + ", listVoit="
				+ listVoit + "]";
	}

}
