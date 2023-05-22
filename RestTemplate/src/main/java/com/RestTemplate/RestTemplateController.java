package com.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {
	@Autowired
	RestTemplate rt;
	@GetMapping(value="/get")
	public String get() {
		String url="http://localhost:8080/hi";
		ResponseEntity<String> response1=rt.exchange(url,HttpMethod.GET,null,new ParameterizedTypeReference<String>() {});
	String res=response1.getBody();
	return "The response is "+res;
	}
	@GetMapping(value="/getpro")
	public List<Products> getpro(){
		String url1="http://localhost:8080/addListPro";
		ResponseEntity<List<Products>> response2=rt.exchange(url1,HttpMethod.GET,null,new ParameterizedTypeReference<List<Products>>() {});
	List<Products> re=response2.getBody();
	return re;
	}
//	@GetMapping(value="/getNetPrice")
//	public List<Integer> getNetPrice(){
//		String url1="http://localhost:8080/addListPro";
//		String url2="http://localhost:8082/getTaxByHsn/ ";
//		ResponseEntity<List<Products>> response1=rt.exchange(url1, HttpMethod.GET,null,new ParameterizedTypeReference<List<Products>>() {});
//		List<Products> products=response1.getBody();
//		List<Integer> taxes=new ArrayList<>();
//		products.forEach(i->{
//			ResponseEntity<Integer> response2=rt.exchange(url2+i.getHsn(),HttpMethod.GET,null,Integer.class);
//			int t=response2.getBody();
//			taxes.add(i.getPrice()+(i.getPrice()*t/100));
//		});
//		return taxes;
//		
//	}
//	@PostMapping(value="/addPrice")
//	public String addPrice(){
//		String url1="http://localhost:8080/addListPro";
//		String url2="http://localhost:8082/getTaxByHsn/ ";
//		ResponseEntity<String> response1=rt.exchange(url1,HttpMethod.GET,null,String.class);
//		String products=response1.getBody();
//		products.forEach(x->{
//			ResponseEntity<String> response2=rt.exchange(url2+x)
//		});
//	}





@GetMapping(value = "/getallproducts")
public List<Products> getFullProduct() {
	String url1 = "http://localhost:8080/addListPro";
	String url2 = "http://localhost:8082/getTaxByHsn/";
	ResponseEntity<List<Products>> response1 = rt.exchange(url1, HttpMethod.GET, null,
			new ParameterizedTypeReference<List<Products>>() {
			});
	List<Products> products = response1.getBody();
	products.forEach(x -> {
		ResponseEntity<Integer> tax = rt.exchange(url2 + x.getHsn(), HttpMethod.GET, null, Integer.class);
		int t = tax.getBody();
		x.setPrice(x.getPrice() + (x.getPrice() * t / 100));
	});
	return products;
}

}


