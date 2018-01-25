package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.constants.ViewsConstant;

@Controller
@RequestMapping("/example04")
public class Example04Controller {

	/* ======================[ RETURN OBJECT MODEL AND VIEW ]====================== */
	@GetMapping("/request")
	public ModelAndView requestGET(@RequestParam(name="pname", defaultValue="Valor por defecto.", 
	required=false) String _name) {
		ModelAndView mav = new ModelAndView(ViewsConstant.EXAMPLE04);
		mav.addObject("title","Get params");
		mav.addObject("name", _name );
		return mav;
	}
	
	/* ======================[ RETURN OBJECT MODEL AND VIEW ]====================== */
	@GetMapping("/requestPath/{pname}")
	public ModelAndView requestPath(@PathVariable("pname") String _name) {
		ModelAndView mav = new ModelAndView(ViewsConstant.EXAMPLE04);
		mav.addObject("name", _name );
		return mav;
	}
	
}
