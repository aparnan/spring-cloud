package springboot.circuitbreaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductCompositeService {

	@Autowired
    ProductComposite integration;
	
	@RequestMapping("/person")
    public void getProducts() {
		
		Person person = integration.getPerson();
		System.out.println("$$$$$$$$$$$$$$$person:"+person.toString());
	}
	
	@RequestMapping("/project1")
    public void getProject1() {
		integration.getProject1Url();
	}
	
	
}
