package Sbchalet.demo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Equipement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2934843406026152248L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	
	
	@Column
	private String nom;
	
	@Column
	private boolean disponibile;
	
	@Column 
	private String icon;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Chalet chalet;
	
	public Equipement() {
		super();
	}

	public Equipement(int id, String nom, boolean disponibile, String icon) {
		super();
		this.id = id;
		this.nom = nom;
		this.disponibile = disponibile;
		this.icon = icon;
	}

	public Equipement(String nom, boolean disponibile) {
		super();
		this.nom = nom;
		this.disponibile = disponibile;
	}
	
	

	public Equipement(String nom, boolean disponibile, Chalet chalet) {
		super();
		this.nom = nom;
		this.disponibile = disponibile;
		this.chalet = chalet;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isDisponibile() {
		return disponibile;
	}

	public void setDisponibile(boolean disponibile) {
		this.disponibile = disponibile;
	}

	public int getId() {
		return id;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
	
	
	
	
	
}
