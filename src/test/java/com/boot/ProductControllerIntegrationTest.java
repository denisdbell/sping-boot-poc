package com.boot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.advantum.App;
import com.advantum.barcode.controller.product.ProductController;
import com.advantum.barcode.model.Product;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@ActiveProfiles("integration")
public class ProductControllerIntegrationTest {
	
	@Autowired
	private ProductController productController;

	@Test
	@Sql("test-data.sql")
	public void findOne(){
		ResponseEntity<Product> response = productController.findOne(2);
		Product product = response.getBody();
		assertEquals("HELLO",product.getProductCode());
	}
}
