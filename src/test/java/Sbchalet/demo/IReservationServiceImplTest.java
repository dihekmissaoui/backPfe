package Sbchalet.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Sbchalet.demo.controllers.ReservationController;
import Sbchalet.demo.models.Chalet;
import Sbchalet.demo.models.Reservation;
import Sbchalet.demo.models.User;
import Sbchalet.demo.payload.request.ChaletRequest;
import Sbchalet.demo.payload.request.ReservationRequest;
import Sbchalet.demo.repository.ReservationRepository;
import Sbchalet.demo.services.ReservationServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class IReservationServiceImplTest {
	@Autowired
	ReservationRepository rep;
	@Autowired
	ReservationServiceImpl rs ;
	@Autowired
	ReservationController rc ;

	//@Test
	public void testlist() {

		List<Reservation> res = rep.findAll();
		Assertions.assertEquals(15, res.size());

	}
	
	//@Test
	public void testgetById () {
		Optional <Reservation>res = rs.getById(3);
	  Assertions.assertTrue(res.isPresent());
	}
	
	
		
		
	
	
		
		
	

}
