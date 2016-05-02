package fr.projetSTB.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@Entity
@Table(name = "fonctionnalite")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "fonctionnalite")
public class Fonctionnalite implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "priorite", nullable = false)
	@XmlAttribute(required = true)
	private int priorite;
	
	@Column(name = "description", nullable = false, columnDefinition="TEXT")
	@XmlElement(required = true)
	private String description;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	//@Fetch(value = FetchMode.SUBSELECT)
	@XmlElement(required = true)
	private ExigenceFonctionnelles exigenceFonctionnelles;

	public Fonctionnalite(String description, ExigenceFonctionnelles exigenceFonctionnelles, int priorite) {
		this.description = description;
		this.exigenceFonctionnelles = exigenceFonctionnelles;
		this.priorite = priorite;
	}

	public Fonctionnalite() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriorite() {
		return priorite;
	}

	public void setPriorite(int priorite) {
		this.priorite = priorite;
	}

	public ExigenceFonctionnelles getExigenceFonctionnelles() {
		return exigenceFonctionnelles;
	}

	public void setExigenceFonctionnelles(ExigenceFonctionnelles exigenceFonctionnelles) {
		this.exigenceFonctionnelles = exigenceFonctionnelles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Fonctionnalite [id=" + id + ", priorite=" + priorite
				+ ", description=" + description + ", exigenceFonctionnelles=" + exigenceFonctionnelles + "]";
	}
	
	
}
