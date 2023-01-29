package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bean.Category;
import com.bean.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {

	
	@Autowired
	ProductRepository productRepository;
	
	
	@Autowired
	RestTemplate restTemplate;
	
	public String storeProducts(Product product){
		Optional<Product> result = productRepository.findById(product.getPid());
		if(result.isPresent()) {
			return "Product id must be unique";
		}else {
			Category cc = restTemplate.getForObject("http://CATEGORY-MICRO-SERVICE/category/findAllCategoryByName/"+product.getCid(), Category.class);
			System.out.println(cc.getCid()+" "+cc.getCname());
			product.setCid(cc.getCid());
			productRepository.save(product);
			return "Product Details stored successfully";
	}
	
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public String findProduct(int pid) {
		Optional<Product> result = productRepository.findById(pid);
		if(result.isPresent()) {
			return result.get().toString();
		}else {
			return "Product not present";
		}	
	}
	
	public String deleteProduct(int pid) {
		Optional<Product> result = productRepository.findById(pid);
		if(result.isPresent()) {
			Product p = result.get();
			productRepository.delete(p);
			return "Product details deleted successfully";
		}else {
			return "Product not present";
		}
	}
	
	public String updateProduct(Product pp) {
		Optional<Product> result = productRepository.findById(pp.getPid());
		if(result.isPresent()) {
			Product p = result.get();
			p.setUrl(pp.getUrl());
			p.setPrice(pp.getPrice());
			productRepository.saveAndFlush(p);
			return "Product details updated successfully";
		}else {
			return "Product not present";
		}
	}
	
	public String deleteAllProduct() {
		productRepository.deleteAll();
		return "All Record deleted";
	}
}
