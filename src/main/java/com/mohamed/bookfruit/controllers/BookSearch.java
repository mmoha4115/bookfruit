package com.mohamed.bookfruit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Mohamed Mohamed
 */

@Controller
@RequestMapping(value = "search")
public class BookSearch {

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public String displaySearchForm(Model model){
        model.addAttribute("title", "Search for a book by title or isbn");
        return "search/index";
    }

    @RequestMapping(value = "" , method = RequestMethod.POST)
    public String processSearchForm(Model model, @RequestParam String search){
        return "search/index";
    }

}
