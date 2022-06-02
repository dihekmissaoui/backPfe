package Sbchalet.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Sbchalet.demo.models.Facture;
import Sbchalet.demo.models.Reservation;
import Sbchalet.demo.repository.FactureRepository;
import Sbchalet.demo.services.FactureServiceImpl;
import Sbchalet.demo.services.IFactureService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactureServiceImplTest {

	@Autowired
	private FactureRepository REP;
	 @Autowired
     private FactureServiceImpl fs ;
	 
	//@Test
	public void testList() throws Exception {
		List<Facture> fact = REP.findAll();
		Assertions.assertEquals(16, fact.size());
	}

	@Test
	public void testsave() {
		Facture facExpected = new Facture(53,new Date(),13);
        Facture fActuel = REP.save(facExpected);
        Assertions.assertEquals(facExpected.getMontant(), fActuel.getMontant());
	}

	@Test
	public void testupdateFacture() throws Exception {
        Facture fExpected = new Facture (53,new Date(),16);
        Facture fActuel = fs.updateFacture(fExpected.getId(),fExpected);
        Assertions.assertEquals(fExpected.getMontant(), fActuel.getMontant());
	}
	
	  @Test
	  public void testgetById() {
		Optional<Facture> f = fs.getById(47);
		Assertions.assertTrue(f.isPresent());
	
		
		  
	  }

}
