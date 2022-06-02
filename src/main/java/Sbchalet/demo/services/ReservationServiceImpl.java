package Sbchalet.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Sbchalet.demo.models.Chalet;
import Sbchalet.demo.models.Reservation;
import Sbchalet.demo.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements IReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	private static final Logger logger = Logger.getLogger(ReservationServiceImpl.class);

	@Override
	public List<Reservation> list() {
		try {
			logger.info(" Je suis dans ListReservation ");
			logger.debug("Je vais retourner ListReservation");
			logger.info("Je vien de finir l'operation ");
			return (List<Reservation>) this.reservationRepository.findAll();
		} catch (Exception e) {
			logger.error("Error in ListChalet() :", e);
		}
		return new ArrayList<Reservation>();

	}

	@Override
	public Reservation save(Reservation res) {
		try {
			logger.trace("accès à la méthode");
			logger.info("je vais enregister Reservation");
			return this.reservationRepository.save(res);

		} catch (Exception e) {
			logger.error("Error dans save() :", e);
		}
		return new Reservation();
	}

	@Override
	public void remove(int idResarvation) {
		try {
			logger.info("supprimer Reservation= " + idResarvation);
			this.reservationRepository.deleteById(idResarvation);
		} catch (Exception e) {
			logger.error("Error dans remove() :", e);
		}
		logger.info("Reservation n'existe pas");

	}

	@Override
	@Transactional
	public Reservation updateReservation(int idResarvation, Reservation reservation) {
		Reservation finded = null;

			logger.info("je suis dans updateReservation()");
			Optional<Reservation> searchReservation = reservationRepository.findById(idResarvation);
			if (searchReservation.isPresent()) {

				finded = searchReservation.get();
				finded = reservation;
//				if (reservation.getDateDeDebut() != null) {
//					finded.setDateDeDebut(reservation.getDateDeDebut());
//				}
//				if (reservation.getDateDeDefin() != null) {
//					finded.setDateDeDefin(reservation.getDateDeDefin());
//				}
//				if (reservation.getNbNuites() != 0) {
//					finded.setNbNuites(reservation.getNbNuites());
//				}
//				if (reservation.getTotalPrix() != 0) {
//					finded.setTotalPrix(reservation.getTotalPrix());
//				}
//				if (reservation.getNbAdultes() != 0) {
//					finded.setNbAdultes(reservation.getNbAdultes());
//				}
//				if (reservation.getNbEnfant() != 0) {
//					finded.setNbEnfant(reservation.getNbEnfant());
//				}
//				if (reservation.getNbAnimal() != 0) {
//					finded.setNbAnimal(reservation.getNbAnimal());
//				}
//				if (reservation.getStatus() != null) {
//					finded.setStatus(reservation.getStatus());
//				}
//
//				if (reservation.getChalet() != null) {
//					finded.setChalet(reservation.getChalet());
//				}
//				if (reservation.getUser() != null) {
//					finded.setUser(reservation.getUser());
//				}

				logger.debug("je vais lancer updateReservation ,");
				finded = this.reservationRepository.save(finded);
			}			
		
		return finded;

	}

	@Override
	public Optional<Reservation> getById(int idResarvation) {
		try {
			logger.info("je vais afficher le Chalet par id =" + idResarvation);
			return this.reservationRepository.findById(idResarvation);
		} catch (Exception e) {
			logger.error("Error dans getById() :", e);
		}
		return null;
	}

	@Override
	@Transactional
	public Reservation changeStatus(int idResarvation, Reservation reservation) {
		Reservation r = null;
		Optional<Reservation> searchReservation = reservationRepository.findById(idResarvation);
		if (searchReservation.isPresent()) {

			Reservation finded = searchReservation.get();
			finded.setStatus(reservation.getStatus());
			r = this.reservationRepository.save(finded);

		}
		return r;
	}
	
	@Override
	public Reservation getReservationById(int id) {

		try {
			logger.info("je vais afficher le Chalet par id =" + id);
			Optional<Reservation> optional = this.reservationRepository.findById(id);
			Reservation reservation = null;
			if (optional.isPresent()) {
				reservation = optional.get();
				return reservation;
			} else {
				throw new NotFound("Reservation with id:" + id + " is not found", null, null);
			}

		} catch (Exception e) {
			logger.error("Error dans getById() :", e);
		}
		return null;
	}

}
