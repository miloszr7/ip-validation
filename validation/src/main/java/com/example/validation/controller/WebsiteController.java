package com.example.validation.controller;

import com.example.validation.model.Address;
import com.example.validation.service.ValidateAddress;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebsiteController {

    private String result;

    @GetMapping("/dashboard")
    private String dashboard(Model theModel) {

        Address address = new Address();

        theModel.addAttribute("result", result);
        theModel.addAttribute("address", address);

        result = "";

        return "dashboard";
    }

    @PostMapping("/validate")
    private String validate(@ModelAttribute("address") Address theAddress) {

        try {

            this.result = ValidateAddress.validate(theAddress.getIp());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return "redirect:/dashboard";
    }

}
