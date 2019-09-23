package com.hichem.rtibi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hichem.rtibi.entities.Product;

public interface ProductRepos extends CrudRepository<Product, Integer>{

}
