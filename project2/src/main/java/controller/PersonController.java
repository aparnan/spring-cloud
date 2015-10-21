package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import services.PersonServices;

@Controller
public class PersonController {

	private PersonServices personServices;
	
	@Autowired
    public void setPersonService(PersonServices personServices) {
        this.personServices = personServices;
    }
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("products", personServices.listAllPersons());
        System.out.println("Returning persons:");
        return "persons";
    }
}
