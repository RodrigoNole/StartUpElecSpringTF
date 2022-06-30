package pe.edu.upc.StartUp.Elec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.StartUp.Elec.Utils.UserAuthentication;

@Controller
@RequestMapping("/")
public class landingController {
	@Autowired
	private UserAuthentication userAuthentication;

	@GetMapping
	public String getIndex(Model model) {

		if (userAuthentication.isAuthenticated()) { // Enviar los datos del Segmento al html
			return "index";

		}

		return "landingPage";

	}
}
