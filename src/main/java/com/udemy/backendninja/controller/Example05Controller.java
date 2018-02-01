package com.udemy.backendninja.controller;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.component.ExampleComponent;
import com.udemy.backendninja.constants.ViewsConstant;
import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example05")
public class Example05Controller {

	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	public static final Log LOGGER = LogFactory.getLog(Example05Controller.class);
	
	private Person objPerson = new Person("Bill","Gates",32);
	private ArrayList<Person> listPerson = new ArrayList<>(3);
	
	public Example05Controller() {
		this.listPerson.add(new Person("Patrick", "Salguero", 22 ));
		this.listPerson.add(new Person("Cesar", "Salguero", 24));
		this.listPerson.add(new Person("Raquel", "Avalos", 24));
	}
	
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
		return new RedirectView("/example05/post/string");
	}
	
	
	/* ======================[ RETURN STRING VIEW ]================================ */
	@GetMapping("/post/string")
	public String requestStrPost( Model model ) {
		model.addAttribute("person", new Person());
		model.addAttribute("result", "");
		return ViewsConstant.EXAMPLE05;
	}
	
	/* ======================[ RETURN OBJECT MODEL AND VIEW ]====================== */
	@PostMapping("/post/addPerson")
	public ModelAndView requestMavPost(@ModelAttribute("person") Person person ) {
		ModelAndView mav = new ModelAndView(ViewsConstant.EXAMPLE05);
		mav.addObject("person",person);
		int a = 5 / 0;
		mav.addObject("result", "Se ha recibo la información");
		return mav;
	}
	
	/* ======================[ RETURN OBJECT MODEL AND VIEW ]====================== */
	@GetMapping("/mav")
	public ModelAndView complexMAV( ) {
		exampleComponent.sayHellow("Patrick Salguero");
		ModelAndView mav = new ModelAndView( ViewsConstant.EXAMPLE03 );
		mav.addObject("person", this.objPerson );
		mav.addObject("title", "Objecto complejos - MAV");
		mav.addObject("list", this.listPerson);
		return mav;
	}
	
}
