package Sbchalet.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Sbchalet.demo.models.DatabaseFile;
import Sbchalet.demo.repository.DatabaseFileRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class DatabaseFileServiceTest {
	@Autowired
	DatabaseFileRepository rep;

	//@Test
	public void testgetAll() throws Exception{
		List<DatabaseFile> data = rep.findAll();
		Assertions.assertEquals(41, data.size());

	}

}
