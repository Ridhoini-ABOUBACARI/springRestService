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
@Table(name = "equipe")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "equipe")
public class Equipe implements Serializable {
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
	private List<Personne> membre = new ArrayList<Personne>();	
	
	
	public List<Personne> getMembre() {
		return membre;
	}

	public void setMembre(List<Personne> membre) {
		this.membre = membre;
	}
	
	public boolean addMembre(Personne m){
		return membre.add(m);
	}
	
	public boolean removeMembre(Personne m){
		for(Personne personne: this.membre){
			if(personne.equals(m))
				return membre.remove(personne);
		}
		return false;
			
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Equipe [id=" + id + ", membre=" + membre + "]";
	}	
	
}
