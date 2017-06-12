package com.boot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.advantum.App;
import com.advantum.barcode.model.Product;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@ActiveProfiles("integration")
@WebIntegrationTest
public class ProductControllerWebIntegrationTest {

	@Test
	public void findOneTest(){
		RestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<Product> response = restTemplate.getForEntity("http://localhost:8282/api/product/2", Product.class);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		Product product = response.getBody();
		assertEquals(product.getProductCode(),"HELLO");
	}
}
