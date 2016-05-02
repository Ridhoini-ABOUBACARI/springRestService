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
@Table(name = "fonctionnalites")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "fonctionnalites")
public class Fonctionnalites implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToMany(cascade = CascadeType.PERSIST)
	@XmlElement(required = true, name = "fonctionnalite")
	private List<Fonctionnalite> fonctionnalite = new ArrayList<Fonctionnalite>();

	public List<Fonctionnalite> getFonctionnalite() {
		return fonctionnalite;
	}

	public void setFonctionnalites(List<Fonctionnalite> fonctionnalite) {
		this.fonctionnalite = fonctionnalite;
	}

	public boolean addFonctionnalite(Fonctionnalite f) {
		return fonctionnalite.add(f);
	}

	public boolean removeFonctionnalite(Fonctionnalite f) {
		for (Fonctionnalite fonctionnalite : this.fonctionnalite) {
			if (f.equals(fonctionnalite))
				return this.fonctionnalite.remove(fonctionnalite);
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
		return "Fonctionnalites [id=" + id + ", fonctionnalite=" + fonctionnalite + "]";
	}

}
