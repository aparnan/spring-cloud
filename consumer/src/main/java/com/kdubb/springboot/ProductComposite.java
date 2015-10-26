package com.kdubb.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import com.netflix.ribbon.proxy.annotation.Hystrix;

@Component
public class ProductComposite {
	
	@Autowired
    private DiscoveryClient discoveryClient;
	
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	
   
	@HystrixCommand(fallbackMethod = "defaultPerson")
    public Product  getProduct() {
		System.out.println("########### hello getProduct");
		Product product = restTemplate.getForObject("http://product-service/product?name=aparna", Product.class);
		System.out.println("********* product anme: "+product.getName());
		return product;
    }
	
	public Product defaultPerson() {
		System.out.println("%%%%%%%%%%%%% returning from default person");
		return new Product();
	}
    
	
}
