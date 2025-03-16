package com.jlgale.springboot_web.controllers;

import com.jlgale.springboot_web.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class UserController {
    //  /details
    //  /details/model
    //  /details/map
    //  /detailsmodelmap


    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("JL", "Gale");
        model.addAttribute("h1", "Primer hola mundo con spring");
        model.addAttribute("title", "SpringBoot");
        model.addAttribute("user", user);
//        model.addAttribute("firstname", user.getFirstname());
//        model.addAttribute("lastname", user.getLastname());

//        model.addAttribute("name1", "mariana");
//        model.addAttribute("name2", "cecilia");
//        model.addAttribute("name3", "milton");
        return "details2";
    }

    @GetMapping("/details/model")
    public String detailsModel(Model model) {
        model.addAttribute("h1", "Primer hola mundo con spring");
        model.addAttribute("title", "SpringBoot");
        model.addAttribute("firstname", "JL");
        model.addAttribute("lastname", "Gale");
        model.addAttribute("name1", "mariana");
        model.addAttribute("name2", "cecilia");
        model.addAttribute("name3", "milton");
        return "details";
    }

    @GetMapping("/details/map")
    public String detailsMap(Map<String, Object> model) {
        model.put("h1", "Primer hola mundo con spring");
        model.put("title", "SpringBoot");
        model.put("firstname", "JL");
        model.put("lastname", "Gale");
        model.put("name1", "mariana");
        model.put("name2", "cecilia");
        model.put("name3", "milton");
        return "details";
    }

    @GetMapping("/detailsmodelmap")
    public String detailsModelAndMap(Map<String, Object> map, Model model) {
        model.addAttribute("h2", "Primer hola mundo con spring");
        model.addAttribute("title", "SpringBoot");
        model.addAttribute("firstname", "JL");
        model.addAttribute("lastname", "Gale");
        model.addAttribute("name1", "mariana");
        model.addAttribute("name2", "cecilia");
        model.addAttribute("name3", "milton");

        map.put("h2map", "Primer hola mundo con spring");
        map.put("firstnamemap", "JL");
        map.put("lastnamemap", "Gale");
        map.put("name1map", "mariana");
        map.put("name2map", "cecilia");
        map.put("name3map", "milton");
        return "detailsmodelmap";
    }
}
