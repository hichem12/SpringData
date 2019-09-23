package com.hichem.rtibi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

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
	public void testcount() {

		System.out.println("product count is =====================>>>>>>>>>>>>>>>>>>>>>" + productRepos.count());
	}

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
		Product product = productRepos.findById(1).get();
		assertNotNull(product);
		assertEquals("iPhone", product.getName());
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<" + product.getDesc());
	}

	@Test
	public void testUpdate() {
		Product product = productRepos.findById(1).get();
		product.setPrice(12200d);
		productRepos.save(product);
	}

	/*
	 * @Test public void testDelete() { if (productRepos.existsById(1)) {
	 * System.out.println("deleting a product:"); productRepos.deleteById(1);
	 * 
	 * }
	 * 
	 * }
	 */
	@Test
	public void findByNameTest() {
		List<Product> products=productRepos.findByName("x");
		products.forEach(p->System.out.println(p.getDesc()));
	}


}
