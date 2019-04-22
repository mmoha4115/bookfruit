package com.mohamed.bookfruit.controllers;

import com.mohamed.bookfruit.models.Book;
import com.mohamed.bookfruit.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping(value = "book")
public class BookView {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private ChapterDao chapterDao;
    @Autowired
    private FruitDao fruitDao;



    @RequestMapping(value = "/{id}" , method=RequestMethod.GET)
    public String displayBookViewForm(Model model, @PathVariable int id){
        Book book = bookDao.findById(id).get();
        model.addAttribute(book);
        model.addAttribute("chapters",book.getChapters());
        return "book/bookview";
    }

    @RequestMapping(value = "chapter/{bookid}/{chapterid}" , method=RequestMethod.GET)
    public String displayChapterViewForm(Model model, @PathVariable int bookid,@PathVariable int chapterid){
        Book book = bookDao.findById(bookid).get();
        model.addAttribute(book);
        model.addAttribute("chapter",book.getChapters().get(chapterid));
        model.addAttribute("fruits",book.getChapters().get(chapterid).getFruits());
        return "book/chapterview";
    }


}
