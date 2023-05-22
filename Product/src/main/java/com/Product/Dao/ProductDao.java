package com.Product.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Product.Entity.Products;
import com.Product.Repository.ProductRepository;

@Repository
public class ProductDao {
@Autowired
ProductRepository proRepo;
public String addProduct(Products p) {
	proRepo.save(p);
	return "Posted Successfully";
}
public String addProductList(List<Products> p) {
	proRepo.saveAll(p);
	return "All Product Posted Successfully";
}
public List<Products> getaddListPro(){
	return proRepo.getaddListpro();
}
}
