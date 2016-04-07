package com.springapp.mvc;

import com.springapp.TimeTests.Test;
import com.springapp.algoritms.DegreeWithMod.DegreeWithMod;
import com.springapp.algoritms.Prime.Prime;
import com.springapp.algoritms.RSA_Encryption.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model, HttpServletRequest request) {
		request.getSession().setAttribute("data", Data.setData(3L, 113L));
		return "index";
	}

	@RequestMapping(value = "/degree_with_mod")
	public String degreeWithMod(ModelMap model){
		return "DegreeWithMod/index";
	}

	@RequestMapping(value = "/count_degree_with_mod", method = RequestMethod.GET)
	public String countDegreeWithMod(ModelMap model, @RequestParam Long number, @RequestParam Long degree, @RequestParam Long mod){
		DegreeWithMod degreeWithMod = new DegreeWithMod();
		model.addAttribute("count", degreeWithMod.count(number, degree, mod));
		return "DegreeWithMod/result";
	}

	@RequestMapping(value = "/test_degree_with_mod", method = RequestMethod.GET)
	public String testDegreeWithMod(ModelMap model){
		Test test = new Test();
		model.addAttribute("timetest", test.test_for_degree_with_mod());
		return "PrimeNumber/count";
	}

	@RequestMapping(value = "/prime")
	public String prime_page(ModelMap model){return "PrimeNumber/index";}

	@RequestMapping(value = "/count_prime", method = RequestMethod.GET)
	public String countPrime(ModelMap model, @RequestParam long number){
		Prime prime = new Prime();
		model.addAttribute("count", prime.isPrime(number));
		return "PrimeNumber/result";
	}

	@RequestMapping(value = "/test_prime", method = RequestMethod.GET)
	public String testPrime(ModelMap model){
		Test test = new Test();
		model.addAttribute("timetest", test.test_for_prime());
		return "PrimeNumber/count";
	}
}