package com.boot;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.advantum.barcode.controller.product.ProductController;
import com.advantum.barcode.model.Product;
import com.advantum.barcode.product.ProductService;

public class ProductControllerTest {
	
	@InjectMocks
	private ProductController productController;
	
	@Mock
	private ProductService productService;
	
	//Mock Product
	private Product product = new Product();
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testProductControllerGet(){
		
		product.setProductId(1);
		
		when(productService.findOne(1)).thenReturn(product);
		
		ResponseEntity<Product> response = productController.findOne(1);
		
		//Check if 200 was returned
		assertEquals(HttpStatus.OK,response.getStatusCode());
		
		//Check that the product returned the correct
		assertEquals(product.getProductId(),response.getBody().getProductId());
		
		//Ensure that save method was called only once
		verify(productService).findOne(1);
	}
}
