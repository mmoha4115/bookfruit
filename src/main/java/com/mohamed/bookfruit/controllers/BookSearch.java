package com.mohamed.bookfruit.controllers;

import com.mohamed.bookfruit.models.Author;
import com.mohamed.bookfruit.models.Book;
import com.mohamed.bookfruit.models.data.AuthorDao;
import com.mohamed.bookfruit.models.data.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Mohamed Mohamed
 */

@Controller
@RequestMapping(value = "search")
public class BookSearch {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private AuthorDao authorDao;


    @RequestMapping(value = "" , method = RequestMethod.GET)
    public String displaySearchForm(Model model){
        model.addAttribute("title", "Search for a book by isbn #");
        model.addAttribute(new Book());
        model.addAttribute(new Author());
        return "search/index";
    }


    @RequestMapping(value = "" , method = RequestMethod.POST)
    public String processSearchForm(@ModelAttribute @Valid Book newBook, Model model,Errors errors,@RequestParam String authorname ){
        if (errors.hasErrors()){
            model.addAttribute("title","Search for a book by isbn #");
            return "search/index";
        }
        Author author=new Author(authorname);
        authorDao.save(author);
        newBook.setAuthor(author);
        bookDao.save(newBook);
        model.addAttribute("book",newBook);
        return "search/addChapters";
    }

}
