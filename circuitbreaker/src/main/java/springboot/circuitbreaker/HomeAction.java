package springboot.circuitbreaker;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
public class HomeAction {
	
	@Autowired
	private ServiceProvider serviceProvider;

	@RequestMapping({ "/index", "/" })
    public String index(final Model model) {
		
        return "/home";
    }
	
	@RequestMapping({ "/getperson" })
    public void getPerson(HttpServletResponse httpServletResponse) {
		System.out.println("%%%%%%%%% controller serviceProvider.getPersonLink():"+serviceProvider.getPersonLink());
		try {
			httpServletResponse.sendRedirect(serviceProvider.getPersonLink());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return "redirect: yahoo.com";
    }
}
