package com.advantum.barcode.product;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advantum.barcode.model.Product;
import com.advantum.barcode.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public  List<Product> list(){
		 
		 List<Product> products = productRepository.findAll();
		
		 return products;
	}
	
	
	public Product findOne(Integer id){
		
		Product product = productRepository.findOne(id);
		
		return product;
	}
	

	public List<Product> addMultiple(List<Product> products){
		
		List<Product> savedProducts = productRepository.save(products);
		
		return savedProducts;	
	}
	
	public Product add(Product product){
		
		Product savedProduct = productRepository.saveAndFlush(product);
		
		return savedProduct;
	}
	
	
	public Product update(Integer id, Product product){
		
		Product exisitingProduct = productRepository.findOne(id);
		BeanUtils.copyProperties(product, exisitingProduct);
		Product updatedProduct =  productRepository.saveAndFlush(product);
		
		return updatedProduct;

	}
	
	public void deleteMultiple(List<Product> products){
		productRepository.delete(products);
	}
	
	public void delete(Integer id){
		 productRepository.delete(id);
	}
}
