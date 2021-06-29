package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	@RequestMapping("/")
	public ModelAndView test01(ModelAndView mv) {
		mv.addObject("AAA", "AAA");
		mv.setViewName("web01");
		return mv;
	}

	@GetMapping("/age_display")
	public ModelAndView test02(ModelAndView mv) throws Exception {
		int age = 23;

		try {
			int result = age / 0;
		} catch (Exception e) {
			throw new Exception("エラーだよ");
		}

		mv.addObject("AGE", age);

		mv.setViewName("web01");
		return mv;
	}
}
