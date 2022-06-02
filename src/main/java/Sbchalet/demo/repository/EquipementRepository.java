package Sbchalet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Sbchalet.demo.models.Equipement;

public interface EquipementRepository extends JpaRepository<Equipement, Integer> {

}
