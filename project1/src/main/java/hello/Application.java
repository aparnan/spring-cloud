package hello;

import java.util.List;
import org.springframework.context.ApplicationContext;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		System.out.println("%%%%%%%%%%%%%% ctx.getApplicationName:"+ctx.getApplicationName());
		System.out.println("%%%%%%%%%%%%%% ctx.getDisplayName:"+ctx.getDisplayName());
		
		
//		new SpringApplicationBuilder(Application.class)
//        .web(false)
//        .run(args);
	}
	
	
	// Project 1 is talking to p[roject 2 service using Eureka server.
	@Component
	public static class DiscoveryClientExample implements CommandLineRunner {

	    @Autowired
	    private DiscoveryClient discoveryClient;

	    @Override
	    public void run(String... strings) throws Exception {
	        discoveryClient.getInstances("project2").forEach((ServiceInstance s) -> {
	            System.out.println("register********************: "+ToStringBuilder.reflectionToString(s));
	            System.out.println("Geturi *********: "+s.getUri());
	            System.out.println("Getport**********"+s.getPort());
	            
	        });
	    }
	}
}

