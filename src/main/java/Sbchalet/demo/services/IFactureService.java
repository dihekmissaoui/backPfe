package Sbchalet.demo.services;

import java.util.List;
import java.util.Optional;

import Sbchalet.demo.models.Facture;

public interface IFactureService {
	
	List<Facture> list();

	Facture save(Facture f);

	void removeFacture(int id_facture);

	Facture updateFacture(int id_facture, Facture facture);

	Optional<Facture> getById(int id_facture);
	
    
}
