package com.hichem.rtibi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hichem.rtibi.entities.Student;
import com.hichem.rtibi.repositories.StudentRepos;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDataTest {
	@Autowired
	private StudentRepos studentRepos;
	
	@Test
	public void createTest() {
		Student student = new Student();
		student.setFirstName("hichem");
		student.setLastName("rtibi");
		student.setScore(80);
		studentRepos.save(student);
		Student student2 = new Student();
		student2.setFirstName("nadia");
		student2.setLastName("samali");
		student2.setScore(55);
		studentRepos.save(student2);
		
	}

}
