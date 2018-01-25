package com.udemy.backendninja.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.constants.ViewsConstant;
import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example03")
public class Example03Controller {

	private Person objPerson = new Person("Bill","Gates",32);
	private ArrayList<Person> listPerson = new ArrayList<>(3);
	
	public Example03Controller() {
		this.listPerson.add(new Person("Patrick", "Salguero", 22 ));
		this.listPerson.add(new Person("Cesar", "Salguero", 24));
		this.listPerson.add(new Person("Raquel", "Avalos", 24));
	}
	
	/* ======================[ RETURN STRING VIEW ]================================ */
	@GetMapping("/string")
	public String complexString( Model model ) {
		model.addAttribute("person", this.objPerson );
		model.addAttribute("title","Objetos complejos - String");
		model.addAttribute("list", this.listPerson);
		return ViewsConstant.EXAMPLE03;
	}
	
	/* ======================[ RETURN OBJECT MODEL AND VIEW ]====================== */
	@GetMapping("/mav")
	public ModelAndView complexMAV( ) {
		ModelAndView mav = new ModelAndView( ViewsConstant.EXAMPLE03 );
		mav.addObject("person", this.objPerson );
		mav.addObject("title", "Objecto complejos - MAV");
		mav.addObject("list", this.listPerson);
		return mav;
	}
	
}
