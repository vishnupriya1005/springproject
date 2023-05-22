package com.Product.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Product.Dao.ProductDao;
import com.Product.Entity.Products;

@Service
public class ProductService {
	@Autowired
	ProductDao proDao;
	public String addProduct(Products p) {
		return proDao.addProduct(p);
	}
	public String addProductList(List<Products> p) {
		return proDao.addProductList(p);
	}
	public List<Products> getaddListPro(){
		return proDao.getaddListPro();
	}

}