package com.springapp.mvc;

import com.springapp.algoritms.Prime.Prime;
import com.springapp.algoritms.RSA_Encryption.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Roman on 23.03.2016.
 */
@Controller
@RequestMapping("/encryption")
public class EncryptionController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model, HttpServletRequest request) {
        Data data = (Data) request.getSession().getAttribute("data");
        model.addAttribute("data", data);
        return "Encrypt/index";
    }

    @RequestMapping(value = "/update/first_prime", method = RequestMethod.GET)
    public String updateFirstPrime(Model model, HttpServletRequest request, @RequestParam Long first_prime) {
        Prime prime = new Prime();
        if (prime.isPrime(first_prime)) {
            Data data1 = (Data) request.getSession().getAttribute("data");
            Data data2 = Data.setData(first_prime, data1.getSecond_prime());
            request.getSession().setAttribute("data", data2);
        }
        return "redirect:/encryption/";
    }

    @RequestMapping(value = "/update/second_prime", method = RequestMethod.GET)
    public String updateSecondPrime(Model model, HttpServletRequest request, @RequestParam Long second_prime) {
        Prime prime = new Prime();
        if (prime.isPrime(second_prime)) {
            Data data1 = (Data) request.getSession().getAttribute("data");
            Data data2 = Data.setData(data1.getFirst_prime(), second_prime);
            request.getSession().setAttribute("data", data2);
        }
        return "redirect:/encryption/";
    }
}
