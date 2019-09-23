package com.hichem.rtibi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hichem.rtibi.entities.Product;
import java.lang.String;
import java.util.List;

public interface ProductRepos extends CrudRepository<Product, Integer>{
	List<Product> findByName(String name);

}
