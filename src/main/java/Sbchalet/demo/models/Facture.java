package Sbchalet.demo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Facture implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4910413982013885428L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Temporal(TemporalType.DATE) // pour avoir le type de date
	private Date dateFacture;
	private float montant;
	
	private boolean isTotalPayment;
	private float rest;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Reservation reservation;

	public Facture() {

	}

	public Facture(int id, Date dateFacture, float montant) {
		super();
		this.id = id;
		this.dateFacture = dateFacture;
		this.montant = montant;
	}

	public Facture(Date dateFacture, float montant, Reservation reservation) {
		super();
		this.dateFacture = dateFacture;
		this.montant = montant;
		this.reservation = reservation;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public boolean isTotalPayment() {
		return isTotalPayment;
	}

	public void setTotalPayment(boolean isTotalPayment) {
		this.isTotalPayment = isTotalPayment;
	}

	public float getRest() {
		return rest;
	}

	public void setRest(float rest) {
		this.rest = rest;
	}

	
	

}
