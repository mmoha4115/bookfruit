package com.mohamed.bookfruit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Mohamed Mohamed
 */

@Controller
@RequestMapping(value = "")
public class Home {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String displayHomePage(Model model){
        model.addAttribute("title","Home Page");
        return "home/index";
    }


}
