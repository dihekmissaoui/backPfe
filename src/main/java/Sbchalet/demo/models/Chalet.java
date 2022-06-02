package Sbchalet.demo.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Chalet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String description;
	@Column
	private double prix;
	@Column
	private String adresse;
	@Column
	private String etat;
	@Column
	private String ville;
	@Column
	private String codeZip;

	@Column
	private int maxAdulte;
	@Column
	private int maxEnfant;
	@Column
	private int maxBebe;
	@Column
	private int maxAnimal;

	@JsonManagedReference
	@OneToMany(mappedBy = "chalet", fetch = FetchType.EAGER, targetEntity = Reservation.class, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Set<Reservation> reservations = new HashSet<Reservation>();

	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "chalet", orphanRemoval = true)
	private List<DatabaseFile> images = new ArrayList<DatabaseFile>();

	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "chalet", orphanRemoval = true)
	private List<Equipement> equipements = new ArrayList<Equipement>();

	public Chalet() {
	}

	public Chalet(int id, String description, double prix, String adresse, String etat, String ville, String codeZip,
			Set<Reservation> reservations, List<DatabaseFile> images) {
		super();
		this.id = id;
		this.description = description;
		this.prix = prix;
		this.adresse = adresse;
		this.etat = etat;
		this.ville = ville;
		this.codeZip = codeZip;
		this.reservations = reservations;
		this.images = images;
	}

	public Chalet(String description, double prix, String adresse, String etat, String ville, String codeZip,
			Set<Reservation> reservations, List<DatabaseFile> images) {
		super();
		this.description = description;
		this.prix = prix;
		this.adresse = adresse;
		this.etat = etat;
		this.ville = ville;
		this.codeZip = codeZip;
		this.reservations = reservations;
		this.images = images;
	}

	public Chalet(String description, double prix, String adresse, String etat, String ville, String codeZip) {
		super();
		this.description = description;
		this.prix = prix;
		this.adresse = adresse;
		this.etat = etat;
		this.ville = ville;
		this.codeZip = codeZip;
	}
	
	
	

	public Chalet(String description, double prix, String adresse, String etat, String ville, String codeZip,
			int maxAdulte, int maxEnfant, int maxBebe, int maxAnimal) {
		super();
		this.description = description;
		this.prix = prix;
		this.adresse = adresse;
		this.etat = etat;
		this.ville = ville;
		this.codeZip = codeZip;
		this.maxAdulte = maxAdulte;
		this.maxEnfant = maxEnfant;
		this.maxBebe = maxBebe;
		this.maxAnimal = maxAnimal;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodeZip() {
		return codeZip;
	}

	public void setCodeZip(String codeZip) {
		this.codeZip = codeZip;
	}

	public List<DatabaseFile> getImages() {
		return images;
	}

	public void setImages(List<DatabaseFile> images) {
		this.images = images;
	}

	public int getId() {
		return id;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public int getMaxAdulte() {
		return maxAdulte;
	}

	public void setMaxAdulte(int maxAdulte) {
		this.maxAdulte = maxAdulte;
	}

	public int getMaxEnfant() {
		return maxEnfant;
	}

	public void setMaxEnfant(int maxEnfant) {
		this.maxEnfant = maxEnfant;
	}

	public int getMaxBebe() {
		return maxBebe;
	}

	public void setMaxBebe(int maxBebe) {
		this.maxBebe = maxBebe;
	}

	public int getMaxAnimal() {
		return maxAnimal;
	}

	public void setMaxAnimal(int maxAnimal) {
		this.maxAnimal = maxAnimal;
	}

	public List<Equipement> getEquipements() {
		return equipements;
	}

	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
	}

}
