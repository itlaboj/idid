package com.example.demo.p04;

import org.springframework.web.servlet.ModelAndView;

public class MyClass {
	private ID id;

	public MyClass(ID id) {
		this.id = id;
	}

	public void setMessage(ModelAndView mv) {
		mv.addObject("message", id.getMessage());
	}
}
