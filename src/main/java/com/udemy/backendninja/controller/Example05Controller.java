package com.udemy.backendninja.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.component.ExampleComponent;
import com.udemy.backendninja.constants.ViewsConstant;
import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;

@Controller
@RequestMapping("/example05")
public class Example05Controller {
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	private Person objPerson = new Person("Bill","Gates",32);
	public static final Log LOGGER = LogFactory.getLog(Example05Controller.class);
	
	/* ======================[ RETURN STRING VIEW ]================================ */
	@GetMapping("/")
	public String index() {
		LOGGER.info("INFO TRACE");
		LOGGER.warn("WARN TRACE");
		LOGGER.error("ERROR TRACE");
		LOGGER.debug("DEBUG TRACE");
		return "redirect:/example05/post/string";
	}
	
	@GetMapping("/index")
	public RedirectView redirect() {
		return new RedirectView("/example05/mav");
	}
	
	
	/* ======================[ RETURN STRING VIEW ]================================ */
	@GetMapping("/post/string")
	public String requestStrPost( Model model ) {
		model.addAttribute("person", new Person());
		model.addAttribute("result", "");
		return ViewsConstant.EXAMPLE05;
	}
	
	/* ======================[ RETURN STRING VIEW ]================================ */
	@PostMapping("/post/addPerson")
	public String requestMavPost(@Valid @ModelAttribute("person") Person person, BindingResult binding ) {
		if( !binding.hasErrors() ) {
			this.exampleService.addPerson( person );
			return "redirect:/example05/mav";
		}else {
			binding.getAllErrors().stream().forEach(m -> LOGGER.error("Error: " + m.getDefaultMessage()) );
			return ViewsConstant.EXAMPLE05;
		}
	}
	
	/* ======================[ RETURN OBJECT MODEL AND VIEW ]====================== */
	@GetMapping("/mav")
	public ModelAndView complexMAV( ) {
		exampleComponent.sayHellow("Patrick Salguero");
		ModelAndView mav = new ModelAndView( ViewsConstant.EXAMPLE03 );
		mav.addObject("person", this.objPerson );
		mav.addObject("title", "Objecto complejos - MAV");
		mav.addObject("list", exampleService.getListPeople());
		return mav;
	}
	
}
