package com.hichem.rtibi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hichem.rtibi.entities.Employe;
import com.hichem.rtibi.repositories.EmployeRepos;
@RunWith(SpringRunner.class)
@SpringBootTest
public class IdGenerateurTest {
	@Autowired
	private EmployeRepos employeRepos;
	@Test
	public void testCreateEmploye()
	{
		Employe employe=new Employe();
		
		employe.setName("hichem");
		employeRepos.save(employe);
	}

}
