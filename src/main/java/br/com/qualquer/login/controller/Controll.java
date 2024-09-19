package br.com.qualquer.login.controller;

import jakarta.servlet.http.HttpServletRequest; // Import para capturar os parâmetros da requisição
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Controll {

    @GetMapping("/")
    public ModelAndView informacaoForm(){
        return new ModelAndView("informacao");
    }


    @GetMapping("/login")
    public ModelAndView loginForm() {
        return new ModelAndView("Login");
    }

    @PostMapping("/login")
    public ModelAndView login(String email, String password) {
        // Captura os valores dos parâmetros da requisição diretamente
       
        // Usuário e senha fixos para validação
        String fixedEmail = "yurimartinelli123@gmail.com";
        String fixedPassword = "123456";

        // Inicializa o ModelAndView com a view de Login
        ModelAndView model = new ModelAndView("Login");

        // Adiciona os parâmetros recebidos ao ModelAndView
        model.addObject("email", email);
        model.addObject("password", password);

        if (email.equals(fixedEmail) && password.equals(fixedPassword)) {
            return new ModelAndView("redirect:/sucess"); 
        } else {
           return new ModelAndView("redirect:/erro");
        }

    }

    @GetMapping("/sucess")
    public ModelAndView sucessoForm() {
        return new ModelAndView("Sucess");
    }


    @GetMapping("/erro")
    public ModelAndView erroForm(){
        return new ModelAndView ("Erro");
    }
    
}
