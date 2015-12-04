package py.uca.infraestructura.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	public static final String helloText = "Bienvenidos al curso de Infraestructura | UCA 2015";

	@RequestMapping("/")
	public String index() {
		return helloText;
	}

}