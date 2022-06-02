package Sbchalet.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Sbchalet.demo.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Integer>{

	List<Reservation> getReservationByChaletId(int id);
}
