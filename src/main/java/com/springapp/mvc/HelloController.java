package com.springapp.mvc;

import com.springapp.TimeTests.Test;
import com.springapp.algoritms.DegreeWithMod.DegreeWithMod;
import com.springapp.algoritms.DegreeWithMod.Result;
import com.springapp.algoritms.Prime.Prime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = "/degree_with_mod")
	public String degreeWithMod(ModelMap model){
		return "DegreeWithMod/degree_with_mod";
	}

	@RequestMapping(value = "/count_degree_with_mod", method = RequestMethod.GET)
	public String countDegreeWithMod(ModelMap model, @RequestParam Long number, @RequestParam Long degree, @RequestParam Long mod){
		DegreeWithMod degreeWithMod = new DegreeWithMod();
		Result result = degreeWithMod.count(number, degree, mod);
//		Test timetest = new Test();
//		Map<Integer, Long> hashmap = new HashMap<Integer, Long>();
//		hashmap = timetest.test_for_degree_with_mod(number, degree, mod);
//		model.addAttribute("timetest", hashmap);
		model.addAttribute("count", result.getCount());
		return "DegreeWithMod/count";
	}

	@RequestMapping(value = "/prime")
	public String prime_page(ModelMap model){return "PrimeNumber/index";}

	@RequestMapping(value = "/count_prime", method = RequestMethod.GET)
	public String countPrime(ModelMap model, @RequestParam long number){
		Prime prime = new Prime();

//		Result result = degreeWithMod.count(number, degree, mod);
//		Test timetest = new Test();
//		Map<Integer, Long> hashmap = new HashMap<Integer, Long>();
//		hashmap = timetest.test_for_degree_with_mod(number, degree, mod);
//		model.addAttribute("timetest", hashmap);
		model.addAttribute("count",prime.isPrime(number));
		return "PrimeNumber/count";
	}
}