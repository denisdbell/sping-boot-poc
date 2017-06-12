package com.advantum.barcode.controller.product;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.advantum.barcode.model.Product;
import com.advantum.barcode.product.ProductService;

@RestController
@RequestMapping("api/")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="products", method = RequestMethod.GET)
	public ResponseEntity <List<Product>> list(){
		
		List<Product> products = productService.list();
		
		if(products.size() == 0){
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="product/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> findOne(@PathVariable Integer id){
		
		Product product = productService.findOne(id);
		
		if(product == null){
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="products", method = RequestMethod.POST)
	public ResponseEntity<List<Product>> addMultiple(@RequestBody List<Product> products){
		
		List<Product> savedProducts = productService.addMultiple(products);
		
		if(savedProducts.size() == 0){
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<List<Product>>(savedProducts,HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="product", method = RequestMethod.POST)
	public ResponseEntity<Product> add(@RequestBody Product product){
		
		Product savedProduct = productService.add(product);
		
		if(savedProduct == null){
			return new ResponseEntity<Product>(HttpStatus.NOT_MODIFIED);
		}else{
			return new ResponseEntity<Product>(savedProduct,HttpStatus.OK);
		}
	
	}
	
	
	@RequestMapping(value="product/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Product> update(@PathVariable Integer id,@RequestBody Product product){
		
		Product exisitingProduct = productService.findOne(id);
		BeanUtils.copyProperties(product, exisitingProduct);
		Product updatedProduct =  productService.add(product);
		
		if(updatedProduct == null){
			return new ResponseEntity<Product>(HttpStatus.NOT_MODIFIED);
		}else{
			return new ResponseEntity<Product>(updatedProduct,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="products", method = RequestMethod.DELETE)
	public void deleteMultiple(@RequestBody List<Product> products){
		productService.deleteMultiple(products);
	}
	
	@RequestMapping(value="product/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id){
		productService.delete(id);
	}
}
