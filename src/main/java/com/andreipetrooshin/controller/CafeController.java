package com.andreipetrooshin.controller;

import com.andreipetrooshin.service.CafeService;
import com.andreipetrooshin.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CafeController {

    @Autowired
    private CafeService cafeService;

    @Autowired
    private DrinkService drinkService;


    @RequestMapping("cafe/{id}")
    public String cafeData(@PathVariable("id")int id, Model model){
        model.addAttribute("cafe", cafeService.get(id));
        model.addAttribute("drinkList", drinkService.getByCafeId(id));
        return "cafe";
    }

    @RequestMapping("cafes")
    public String cafeList(Model model){
        model.addAttribute("cafeList", cafeService.getAll());
        return  "cafes";
    }

}
