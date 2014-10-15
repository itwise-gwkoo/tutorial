package demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller()
@RequestMapping("/hello")
public class Hello {

	@RequestMapping(value = {"/", "", "index.html"}, method = RequestMethod.GET)
	public String index() {
		return "hello";
	}
	
}
