package fr.projetSTB.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "exigences")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "exigenceFonctionnelles")
public class ExigenceFonctionnelles implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	//@Fetch(value = FetchMode.SUBSELECT)
	@XmlElement(required = true)
	private List<ExigenceFonctionnelle> exigenceFonctionnelle = new ArrayList<ExigenceFonctionnelle>();

	public List<ExigenceFonctionnelle> getExigenceFonctionnelle() {
		return exigenceFonctionnelle;
	}

	public void setExigenceFonctionnelles(List<ExigenceFonctionnelle> exigenceFonctionnelle) {
		this.exigenceFonctionnelle = exigenceFonctionnelle;
	}
	
	public boolean addExigence(ExigenceFonctionnelle e){
		return exigenceFonctionnelle.add(e);
	}
	
	public boolean removeExigence(ExigenceFonctionnelle e){
		for(ExigenceFonctionnelle exigence: exigenceFonctionnelle){
			if(e.equals(exigence))
				return this.exigenceFonctionnelle.remove(exigence);
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setExigenceFonctionnelle(List<ExigenceFonctionnelle> exigenceFonctionnelle) {
		this.exigenceFonctionnelle = exigenceFonctionnelle;
	}

	@Override
	public String toString() {
		return "ExigenceFonctionnelles [id=" + id + ", exigenceFonctionnelle="
				+ exigenceFonctionnelle + "]";
	}
	
	
}
