package Sbchalet.demo.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@DynamicUpdate
@DynamicInsert
public class Reservation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4667184954534741481L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Temporal(TemporalType.DATE) // pour avoir le type de date
	private Date dateDeDebut;
	@Temporal(TemporalType.DATE)
	private Date dateDeDefin;

	private float nbNuites;
	private float totalPrix;
	private int nbAdultes;
	private int nbEnfant;
	private int nbAnimal;
	private String status;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "chalet_id")
	private Chalet chalet;
	
	
	@OneToMany
	@JoinColumn(name = "reservation_id")
	private List<DatabaseFile> files = new ArrayList<DatabaseFile>();

	@OneToMany
	@JoinColumn(name = "reservation_id")
	private List<Facture> factures = new ArrayList<Facture>();

	public Reservation() {
	}



	public Reservation(Date dateDeDebut, Date dateDeDefin, float nbNuites, float totalPrix, int nbAdultes, int nbEnfant,
		int nbAnimal, String status, User user, Chalet chalet) {
	super();
	this.dateDeDebut = dateDeDebut;
	this.dateDeDefin = dateDeDefin;
	this.nbNuites = nbNuites;
	this.totalPrix = totalPrix;
	this.nbAdultes = nbAdultes;
	this.nbEnfant = nbEnfant;
	this.nbAnimal = nbAnimal;
	this.status = status;
	this.user = user;
	this.chalet = chalet;
}



	public Date getDateDeDebut() {
		return dateDeDebut;
	}

	public void setDateDeDebut(Date dateDeDebut) {
		this.dateDeDebut = dateDeDebut;
	}

	public Date getDateDeDefin() {
		return dateDeDefin;
	}

	public void setDateDeDefin(Date dateDeDefin) {
		this.dateDeDefin = dateDeDefin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Chalet getChalet() {
		return chalet;
	}

	public void setChalet(Chalet chalet) {
		this.chalet = chalet;
	}

	public int getId() {
		return id;
	}

	public float getNbNuites() {
		return nbNuites;
	}

	public void setNbNuites(float nbNuites) {
		this.nbNuites = nbNuites;
	}

	public float getTotalPrix() {
		return totalPrix;
	}

	public void setTotalPrix(float totalPrix) {
		this.totalPrix = totalPrix;
	}

	public int getNbAdultes() {
		return nbAdultes;
	}

	public void setNbAdultes(int nbAdultes) {
		this.nbAdultes = nbAdultes;
	}

	public int getNbEnfant() {
		return nbEnfant;
	}

	public void setNbEnfant(int nbEnfant) {
		this.nbEnfant = nbEnfant;
	}

	public int getNbAnimal() {
		return nbAnimal;
	}

	public void setNbAnimal(int nbAnimal) {
		this.nbAnimal = nbAnimal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public List<DatabaseFile> getFiles() {
		return files;
	}



	public void setFiles(List<DatabaseFile> files) {
		this.files = files;
	}



	public List<Facture> getFactures() {
		return factures;
	}



	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}


	
	

}
