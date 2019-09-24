package com.hichem.rtibi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
		List<Product> products = productRepos.findByName("x");
		products.forEach(p -> System.out.println(p.getDesc()));
	}

	@Test
	public void testMultipleField() {
		List<Product> products = productRepos.findByNameAndDesc("x", "x");
		products.forEach(p -> System.out.println("finder by multiple field" + p.getPrice()));
	}

	@Test
	public void testByPrice() {
		List<Product> products = productRepos.findByPriceGreaterThanEqual(100d);
		products.forEach(p -> System.out.println(p.getDesc()));
	}

	@Test
	public void findBydescContainigTest() {
		List<Product> products = productRepos.findByDescContains("a");
		products.forEach(p -> System.out.println(p.getDesc()));
	}

	@Test
	public void TestBetween() {
		List<Product> products = productRepos.findByPriceBetween(100d, 1500d);
		products.forEach(p -> System.out.println(p.getDesc()));
	}

	@Test
	public void TestGreatherThan() {
		List<Product> products = productRepos.findByPriceGreaterThan(100d);
		products.forEach(p -> System.out.println(p.getDesc()));
	}

	@Test
	public void TestContaining() {
		List<Product> products = productRepos.findByDescContaining("a");
		products.forEach(p -> System.out.println(p.getDesc()));
	}

	@Test
	public void TestisLikeDesc() {
		List<Product> products = productRepos.findByDescIsLike("%lg%");
		products.forEach(p -> System.out.println(p.getDesc()));
	}

	@Test
	public void TestLikeDesc() {
		List<Product> products = productRepos.findByDescIsLike("%lg%");
		products.forEach(p -> System.out.println(p.getDesc()));
	}
	@Test
	public void TestIn() {
		List<Product> products = productRepos.findByIdIn(Arrays.asList(1,2,3));
		products.forEach(p -> System.out.println(p.getDesc()));
		
	}
	@Test
	public void TestPaging() {
		Pageable pageable=new PageRequest(0, 3);
		Page<Product> results=productRepos.findAll(pageable);
		results.forEach(p->System.out.println(p.getName()));
	}
	
	@Test
	public void testSorting() {
	Iterable<Product> products=productRepos.findAll(new Sort("name"));
	products.forEach(p->System.out.println(p.getName()));
	}
	@Test
	public void testSortingDirection() {
		Iterable<Product> products=productRepos.findAll(new Sort(Direction.DESC, "name","price"));
		products.forEach(p->System.out.println(p.getName()));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
