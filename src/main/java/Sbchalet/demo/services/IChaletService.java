package Sbchalet.demo.services;

import java.util.List;
import java.util.Optional;

import Sbchalet.demo.models.Chalet;

public interface IChaletService {
	List<Chalet> list();

	Chalet save(Chalet ch);

	void remove(int id_chalet);

	Chalet updateChalet(int id_chalet, Chalet chalet);

	Optional<Chalet> getById(int id_chalet);
	
	Chalet getChaletById(int id_chalet);
	
	 
}
