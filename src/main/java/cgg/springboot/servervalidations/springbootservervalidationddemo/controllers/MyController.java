package cgg.springboot.servervalidations.springbootservervalidationddemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cgg.springboot.servervalidations.springbootservervalidationddemo.entities.LoginData;
import jakarta.validation.Valid;



@Controller
public class MyController {
    
    @GetMapping("/form")
    public String openForm(Model m){

        System.out.println("opening form");
        m.addAttribute("loginData", new LoginData());
        return "form";
    }

    //Handler for process form
    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute LoginData loginData,BindingResult result){
        if(result.hasErrors()){
            System.out.println(result);
            return "form";
        }
        System.out.println(loginData);

        //Data process
        return  "success";
    }
}
