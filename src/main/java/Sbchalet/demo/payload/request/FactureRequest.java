package Sbchalet.demo.payload.request;

import java.util.Date;

public class FactureRequest {
	
	private Date dateFacture;
	private float montant;
	private int reservationId;
	public FactureRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FactureRequest(Date dateFacture, float montant, int reservationId) {
		super();
		this.dateFacture = dateFacture;
		this.montant = montant;
		this.reservationId = reservationId;
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
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	
	
	

}
