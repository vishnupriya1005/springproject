package com.Product.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Product.Entity.Products;

public interface ProductRepository extends JpaRepository<Products,Integer> {
@Query(value="select * from products.prod_details",nativeQuery=true)
public List<Products> getaddListpro();
}
