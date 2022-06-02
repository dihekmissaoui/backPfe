package Sbchalet.demo.services;

import java.util.List;

import Sbchalet.demo.models.Equipement;

public interface IEquipementService {
	
	Equipement save(Equipement equipement);
	Equipement patch(int id, Equipement Equipement);
	List<Equipement> find();
	void delete(int id);
}
