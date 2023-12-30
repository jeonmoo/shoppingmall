package com.example.shoppingmall.interfaces;

import com.example.shoppingmall.application.ProductFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ProductFacade productFacade;

    @GetMapping("/login")
    public String goToLogin() {
        return "login";
    }

    @GetMapping("/logout")
    public String goToLogout() {
        return "logout";
    }

    @GetMapping
    public String goToMain(Model model) {
        var products = productFacade.getMainProducts();
        model.addAttribute("products", products);
        return "main";
    }

    @GetMapping("/signUp")
    public String goToSignUp() {
        return "signUp";
    }
}
