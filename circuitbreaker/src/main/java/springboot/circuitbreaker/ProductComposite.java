package springboot.circuitbreaker;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class ProductComposite {
	
	@Autowired
    private DiscoveryClient discoveryClient;
	
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	
    public void  getProject1Url() {
		Person person = new Person();
		discoveryClient.getInstances("project1").forEach((ServiceInstance s) -> {
            String url = s.getUri()+"/people";
            System.out.println("********* Project1 service url: "+url);
          });
    }
    
	@HystrixCommand(fallbackMethod = "defaultPerson")
    public Person  getPerson() {
		Person person = new Person();
            
            ResponseEntity<List<Person>> exchange =
                    this.restTemplate.exchange(
                            "http://project1/people",
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<List<Person>>() {
                            },
                            (Object) "mstine");
            
//         });
		return person;
    }
	
	
	public Person defaultPerson() {

		System.out.println("********** using fallback method defaultProduct returning new product");
		return new Person();
    }
}
