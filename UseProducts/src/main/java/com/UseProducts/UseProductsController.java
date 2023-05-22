package com.UseProducts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UseProductsController {
	@Autowired
	RestTemplate rt;

	@GetMapping(value = "/getNetPrice")
	public List<Integer> getNetPrice() {
		String url1 = "http://localhost:8080/addListPro";
		String url2 = "http://localhost:8082/getTaxByHsn/ ";
		ResponseEntity<List<UseProducts>> response1 = rt.exchange(url1, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<UseProducts>>() {
				});
		List<UseProducts> products = response1.getBody();
		List<Integer> taxes = new ArrayList<>();
		products.forEach(i -> {
			ResponseEntity<Integer> response2 = rt.exchange(url2 + i.getHsn(), HttpMethod.GET, null, Integer.class);
			int t = response2.getBody();
			taxes.add(i.getPrice() + (i.getPrice() * t / 100));
		});
		return taxes;
	}

	@GetMapping(value = "/getallproducts")
	public List<UseProducts> getFullProduct() {
		String url1 = "http://localhost:8080/addListPro";
		String url2 = "http://localhost:8082/getTaxByHsn/";
		ResponseEntity<List<UseProducts>> response1 = rt.exchange(url1, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<UseProducts>>() {
				});
		List<UseProducts> products = response1.getBody();
		products.forEach(x -> {
			ResponseEntity<Integer> tax = rt.exchange(url2 + x.getHsn(), HttpMethod.GET, null, Integer.class);
			int t = tax.getBody();
			x.setPrice(x.getPrice() + (x.getPrice() * t / 100));
		});
		return products;
	}
}