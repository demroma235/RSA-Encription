package com.springapp.mvc;

import com.springapp.algoritms.RSA_Encryption.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

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
        model.addAttribute("name", data.getName());
        return "Encypt/index";
    }
}
