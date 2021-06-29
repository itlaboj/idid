package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DBController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ItemRepository itemRepository;

	@RequestMapping("/db01")
	public ModelAndView db01(ModelAndView mv) {
		List<User> users = userRepository.findAll();
		mv.addObject("users", users);

		mv.setViewName("db01");
		return mv;
	}

	@RequestMapping("/db02")
	public ModelAndView db02(ModelAndView mv) {
		User user = null;

		Optional<User> record = userRepository.findById(11);

		if (!record.isEmpty()) {
			user = record.get();
		}

		mv.addObject("user", user);

		mv.setViewName("db02");
		return mv;
	}

	@RequestMapping("/db03")
	@Transactional
	public ModelAndView db03(ModelAndView mv) {
		//User user = new User(4, "北山隼人");

		//userRepository.saveAndFlush(user);
		//userRepository.delete(user);
		userRepository.deleteById(4);;

		String message = "正常に登録できました。";

		mv.addObject("message", message);

		mv.setViewName("db03");
		return mv;
	}

	@RequestMapping("/db11")
	public ModelAndView db11(ModelAndView mv) {
		List<Customer> customers = customerRepository.findAll();
		mv.addObject("customers", customers);

		mv.setViewName("db11");
		return mv;
	}

	@RequestMapping("/db12")
	public ModelAndView db12(ModelAndView mv) {
		Customer customer = null;

		Optional<Customer> record = customerRepository.findById(1);

		if (!record.isEmpty()) {
			customer = record.get();
		}

		mv.addObject("customer", customer);

		mv.setViewName("db12");
		return mv;
	}

	@RequestMapping("/db13")
	@Transactional
	public ModelAndView db13(ModelAndView mv) {
		Customer customer = new Customer("北山隼人");

		//Customer c = customerRepository.saveAndFlush(customer);
		customerRepository.delete(customer);
		//customerRepository.deleteById(4);;

		String message = "正常に登録できました。";
//		if (c == null) {
//			message = "失敗しました。";
//		}

		mv.addObject("message", message);

		mv.setViewName("db13");
		return mv;
	}

	@RequestMapping("/db21")
	public ModelAndView db21(ModelAndView mv) {
		List<Item> items = itemRepository.findAll();
		mv.addObject("items", items);

		mv.setViewName("db21");
		return mv;
	}

	@RequestMapping("/db22")
	public ModelAndView db22(ModelAndView mv) {
		Item item = null;

		Optional<Item> record = itemRepository.findById(12);

		if (!record.isEmpty()) {
			item = record.get();
		}

		mv.addObject("item", item);

		mv.setViewName("db22");
		return mv;
	}

	@RequestMapping("/db23")
	public ModelAndView db23(ModelAndView mv) {
		List<Item> items = itemRepository.findByPrice(300);
		mv.addObject("items", items);

		mv.setViewName("db21");
		return mv;
	}

}
