package springboot.circuitbreaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class ServiceProvider {
	
	@Autowired
    private DiscoveryClient discoveryClient;

	@HystrixCommand(fallbackMethod = "defaultPersonLink")
	protected String getPersonLink() {
		ServiceInstance serviceInstance = discoveryClient.getInstances("project1").stream().findFirst().get();
		System.out.println("#serviceInstance: "+serviceInstance);
		
		if(serviceInstance != null) {
			System.out.println("%%%%%%%% new serviceInstance.getUri()"+ serviceInstance.getUri());
			return serviceInstance.getUri().toString();
		}
		return "";
	}
	
	@HystrixCommand(fallbackMethod = "defaultPersonLink")
	protected String getPersonDataForHystrix() {
		ServiceInstance serviceInstance = discoveryClient.getInstances("project1").stream().findFirst().get();
		System.out.println("#serviceInstance: "+serviceInstance);
		
		if(serviceInstance != null) {
			System.out.println("%%%%%%%% new serviceInstance.getUri()"+ serviceInstance.getUri());
			return serviceInstance.getUri().toString();
		}
		return "";
	}
	
	protected String defaultPersonLink() {
		
		System.out.println("%%%%%% calling defaultPersonLink mwthod");
		return "https://yahoo.com";
	}
}


