package com.example.demo.p04;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@Autowired
	private HttpSession session;

	@RequestMapping("/index")
	public ModelAndView index(ModelAndView mv) {
		session.invalidate();

		mv.setViewName("p04/index");
		return mv;
	}

	@RequestMapping("/tasu")
	public ModelAndView tasu(ModelAndView mv) {
		Integer total = (Integer)session.getAttribute("TOTAL");
		if (total == null) {
			total = 0;
			session.setAttribute("TOTAL", total);
		}

		mv.setViewName("p04/tasu");
		return mv;
	}

	@PostMapping("/result")
	public ModelAndView result(
			ModelAndView mv,
			@RequestParam("DATA1") int x,
			@RequestParam("DATA2") int y
			) {
		Ohno o = new Ohno();
		int result = o.tasu(x, y);

		Integer total = (Integer)session.getAttribute("TOTAL");
		total += result;
		session.setAttribute("TOTAL", total);

		mv.addObject("RESULT", result);
		mv.addObject("TOTAL", total);

		mv.setViewName("p04/soku");
		return mv;
	}
}
