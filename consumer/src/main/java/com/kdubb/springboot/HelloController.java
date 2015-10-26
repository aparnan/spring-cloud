package com.kdubb.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	@Autowired
	ProductComposite productComposite;
	
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index(Model model) {
   	 // let�s pass some variables to the view script
   	 model.addAttribute("wisdom", "Goodbye XML");
   	 
   	Product product = productComposite.getProduct();
   	System.out.println("^^^^^^^^^^^ HelloController product"+ product.getName());
   	
   	model.addAttribute("product", product);
	 		
   	 // renders /WEB-INF/views/hello.jsp
   	 return "hello"; 
    }
}