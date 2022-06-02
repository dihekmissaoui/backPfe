package Sbchalet.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sbchalet.demo.models.Equipement;
import Sbchalet.demo.repository.EquipementRepository;

@Service
public class EquipementServiceImpl implements IEquipementService{
	
	@Autowired
	EquipementRepository equipementRepository;
	
	@Override
	public Equipement save(Equipement equipement) {
		this.equipementRepository.save(equipement);
		return null;
	}

	@Override
	public Equipement patch(int id, Equipement equipement) {
		Optional<Equipement>fetched = equipementRepository.findById(id);
		Equipement updated = null;
		if(fetched.isPresent()) {
			Equipement loadedEquipement= fetched.get();
			updated = equipementRepository.saveAndFlush(equipement);
		}
		
		return updated;
	}

	@Override
	public List<Equipement> find() {
		// TODO Auto-generated method stub
		return equipementRepository.findAll();
	}

	@Override
	public void delete(int id) {
		this.equipementRepository.deleteById(id);
		
	}

}
