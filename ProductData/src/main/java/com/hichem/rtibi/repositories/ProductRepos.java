package com.hichem.rtibi.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hichem.rtibi.entities.Product;

public interface ProductRepos extends PagingAndSortingRepository<Product, Integer> {
	List<Product> findByName(String name);

	List<Product> findByNameAndDesc(String name, String desc);

	List<Product> findByPriceGreaterThanEqual(Double d);

	List<Product> findByDescContains(String desc);

	List<Product> findByPriceBetween(Double price, Double price1);

	List<Product> findByPriceGreaterThan(Double price);

	List<Product> findByDescContaining(String desc);

	List<Product> findByDescIsLike(String desc);

	List<Product> findByDescLike(String desc);

	List<Product> findByIdIn(List<Integer> ids);

	List<Product> findByIdIn(List<Integer> ids, Pageable pageable);

}
