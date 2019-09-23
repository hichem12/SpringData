package com.hichem.rtibi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hichem.rtibi.entities.Product;
import com.hichem.rtibi.repositories.ProductRepos;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDataApplicationTests {
	@Autowired
	private ProductRepos productRepos;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("iPhone");
		product.setDesc("awesome");
		product.setPrice(1000d);
		productRepos.save(product);
	}

	@Test
	public void testRead() {
		Product product = productRepos.findOne(1);
		assertNotNull(product);
		assertEquals("iPhone", product.getName());
	}

	@Test
	public void testUpdate() {
		Product product = productRepos.findOne(1);
		product.setPrice(1200d);
		productRepos.save(product);
	}
}
