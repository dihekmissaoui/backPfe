package Sbchalet.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Sbchalet.demo.controllers.ChaletController;
import Sbchalet.demo.models.Chalet;
import Sbchalet.demo.payload.request.ChaletRequest;
import Sbchalet.demo.repository.ChaletRepository;
import Sbchalet.demo.services.ChaletServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
class ChaletServiceImplTest {
	
	@Autowired
	ChaletRepository rep ;
	@Autowired
	ChaletServiceImpl chalets;
	@Autowired
	ChaletController ch;

	
	
	public void testlist() throws Exception {
		List<Chalet> chalet = rep.findAll();
		System.out.println(chalet);
		Assertions.assertEquals(14, chalet.size());
		
	}
	
	//@Test 
	public void testmodifyChalet() {
	ChaletRequest chalet = new ChaletRequest(30,"updated",1,"test u","test v","testw ","1",1,1,1,10);
	Chalet chaletA = ch.modifyChalet(chalet.getId(),chalet);
	Assertions.assertEquals(chalet.getMaxEnfant(),chaletA.getMaxEnfant());
	
	}
	//@Test 
	public void testgetById () {
		Optional<Chalet> ch = chalets.getById(30);
		Assertions.assertTrue(ch.isPresent());
		
	}
	 
	//@Test
	public void testaddChalet () {
		ChaletRequest chaletEx = new ChaletRequest("addchalet",1,"alo ","test alo","testalo","3",2,2,25,25);
		Chalet chaletAc = ch.addChalet(chaletEx);
		Assertions.assertEquals(chaletEx.getAdresse(), chaletAc.getAdresse());
	}

}
