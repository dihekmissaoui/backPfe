package Sbchalet.demo.payload.request;

import java.util.ArrayList;
import java.util.List;

public class ChaletRequest {

	private int id;
	private String description;
	private double prix;
	private String adresse;
	private String etat;
	private String ville;
	private String codeZip;
	private int maxAdulte;
	private int maxEnfant;
	private int maxBebe;
	private int maxAnimal;
	private List<SingleImageRequest> images = new ArrayList<SingleImageRequest>();

	public ChaletRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChaletRequest(int id, String description, double prix, String adresse, String etat, String ville,
			String codeZip, int maxAdulte, int maxEnfant, int maxBebe, int maxAnimal) {
		super();
		this.id = id;
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

	public ChaletRequest(String description, double prix, String adresse, String etat, String ville, String codeZip,
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

	public ChaletRequest(String description, double prix, String adresse, String etat, String ville, String codeZip,
			int maxAdulte, int maxEnfant, int maxBebe, int maxAnimal, List<SingleImageRequest> images) {
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
		this.images = images;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<SingleImageRequest> getImages() {
		return images;
	}

	public void setImages(List<SingleImageRequest> images) {
		this.images = images;
	}

}


