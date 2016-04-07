package com.springapp.mvc;

import com.springapp.algoritms.DegreeWithMod.DegreeWithMod;
import com.springapp.algoritms.Prime.Prime;
import com.springapp.algoritms.RSA_Encryption.Data;
import com.springapp.algoritms.RSA_Encryption.Encryption;
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

    @RequestMapping(value = "/count_encrypt", method = RequestMethod.GET)
    public String getEncrypt(Model model, HttpServletRequest request, @RequestParam Long number) {
        DegreeWithMod degreeWithMod = new DegreeWithMod();
        Data data = (Data) request.getSession().getAttribute("data");
        model.addAttribute("result", degreeWithMod.count(number, data.getOpen_key_1(), data.getOpen_key_2()));
        return "Encrypt/result";
    }

    @RequestMapping(value = "/count_interpretation", method = RequestMethod.GET)
    public String getInterpretation(Model model, HttpServletRequest request, @RequestParam Long number) {
        DegreeWithMod degreeWithMod = new DegreeWithMod();
        Data data = (Data) request.getSession().getAttribute("data");
        model.addAttribute("result", degreeWithMod.count(number, data.getPrivate_key_1(), data.getPrivate_key_2()));
        return "Encrypt/result";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTest(Model model, HttpServletRequest request) {
        DegreeWithMod degreeWithMod = new DegreeWithMod();
        Data data = (Data) request.getSession().getAttribute("data");
        for (Long i = data.getFirst_prime();i < data.getModule(); i++){
            Long f = degreeWithMod.count(degreeWithMod.count(i, data.getOpen_key_1(), data.getPrivate_key_2()), data.getPrivate_key_1(), data.getPrivate_key_2());
            if (i.equals(f)){
                System.out.println("i = " + i + " : f = " + f + " : true");
            }
            else{
                System.out.println("i = " + i + " : f = " + f + " : false");
            }
        }
        return "redirect:/encryption/";
    }

    @RequestMapping(value = "/count_encrypt_string", method = RequestMethod.GET)
    public String getEncryptString(Model model, HttpServletRequest request, @RequestParam String string) {
        Encryption encryption = new Encryption();
        Data data = (Data) request.getSession().getAttribute("data");
        model.addAttribute("result", encryption.toEncrypt(string, data.getOpen_key_1(), data.getOpen_key_2()));
        return "Encrypt/result";
    }
    @RequestMapping(value = "/count_deencrypt_string", method = RequestMethod.GET)
    public String getDeEncryptString(Model model, HttpServletRequest request, @RequestParam String string) {
        Encryption encryption = new Encryption();
        Data data = (Data) request.getSession().getAttribute("data");
        model.addAttribute("result", encryption.toEncrypt(string, data.getPrivate_key_1(), data.getPrivate_key_2()));
        return "Encrypt/result";
    }
}
