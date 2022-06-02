package Sbchalet.demo.payload.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import Sbchalet.demo.models.Chalet;
import Sbchalet.demo.models.DatabaseFile;
import Sbchalet.demo.models.Facture;
import Sbchalet.demo.models.User;

public class ReservationResponse {
	private int id;
	private Date dateDeDebut;
	private Date dateDeDefin;
	private float nbNuites;
	private float totalPrix;
	private int nbAdultes;
	private int nbEnfant;
	private int nbAnimal;
	private String status;
	
	private Chalet chalet;
	private User user;
	
	@OneToMany
	private List<DatabaseFile> files = new ArrayList<DatabaseFile>();
	
	private List<Facture> factures = new ArrayList<Facture>();
	
	public ReservationResponse() {
		super();
	}
	public ReservationResponse(int id, Date dateDeDebut, Date dateDeDefin, float nbNuites, float totalPrix,
			int nbAdultes, int nbEnfant, int nbAnimal, String status, Chalet chalet, User user) {
		super();
		this.id = id;
		this.dateDeDebut = dateDeDebut;
		this.dateDeDefin = dateDeDefin;
		this.nbNuites = nbNuites;
		this.totalPrix = totalPrix;
		this.nbAdultes = nbAdultes;
		this.nbEnfant = nbEnfant;
		this.nbAnimal = nbAnimal;
		this.status = status;
		this.chalet = chalet;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Chalet getChalet() {
		return chalet;
	}
	public void setChalet(Chalet chalet) {
		this.chalet = chalet;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
