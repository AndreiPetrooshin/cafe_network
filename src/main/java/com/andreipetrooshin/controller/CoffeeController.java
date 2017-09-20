package com.andreipetrooshin.controller;

import com.andreipetrooshin.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CoffeeController {

    @Autowired
    private DrinkService drinkService;


    @RequestMapping("coffee/{id}")
    public String coffeeData(@PathVariable("id") int id, Model model){
        model.addAttribute("coffee", drinkService.get(id));
        return "coffee";
    }

    @RequestMapping("coffees")
    public String coffeeList(Model model){
        model.addAttribute("coffeeList", drinkService.getAll());
        return "coffees";
    }



}
