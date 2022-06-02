package Sbchalet.demo.payload.request;

import java.util.Date;

import Sbchalet.demo.models.Chalet;
import Sbchalet.demo.models.User;

public class ReservationRequest {

	private int id;
	private Date dateDeDebut;
	private Date dateDeDefin;
	private int chaletId;
	private float nbNuites;
	private float totalPrix;
	private int nbAdultes;
	private int nbEnfant;
	private int nbAnimal;
	private String status;
	private User user;
	
	public ReservationRequest() {
		super();
	}
	
	
	
	public ReservationRequest(Date dateDeDebut, Date dateDeDefin, int chaletId, float nbNuites, float totalPrix) {
		super();
		this.dateDeDebut = dateDeDebut;
		this.dateDeDefin = dateDeDefin;
		this.chaletId = chaletId;
		this.nbNuites = nbNuites;
		this.totalPrix = totalPrix;
	}



	public ReservationRequest(Date dateDeDebut, Date dateDeDefin, int chalet) {
		super();
		this.dateDeDebut = dateDeDebut;
		this.dateDeDefin = dateDeDefin;
		this.chaletId = chalet;
	}
	public int getId() {
		return id;
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
	



	public int getChaletId() {
		return chaletId;
	}



	public void setChaletId(int chaletId) {
		this.chaletId = chaletId;
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



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
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



	public void setId(int id) {
		this.id = id;
	}
	
	
}
