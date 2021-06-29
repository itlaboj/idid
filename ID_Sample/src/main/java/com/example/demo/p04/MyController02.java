package com.example.demo.p04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController02 {
	@RequestMapping("/display")
	public ModelAndView index(ModelAndView mv) {
		MyClass myClass = new MyClass(new Wada());
		myClass.setMessage(mv);

		mv.setViewName("p04/display");
		return mv;
	}
}
