package Sbchalet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Sbchalet.demo.models.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Integer> {
	public Facture findByMontant (float montant);

}
