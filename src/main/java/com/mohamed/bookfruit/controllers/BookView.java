package com.mohamed.bookfruit.controllers;

import com.mohamed.bookfruit.models.Book;
import com.mohamed.bookfruit.models.Chapter;
import com.mohamed.bookfruit.models.Fruit;
import com.mohamed.bookfruit.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        model.addAttribute("title",book.getTitle()+"");
        model.addAttribute(book);
        model.addAttribute("chapters",book.getChapters());
        return "book/bookview";
    }

    @RequestMapping(value = "chapter/{bookid}/{chapterid}" , method=RequestMethod.GET)
    public String displayChapterViewForm(Model model, @PathVariable int bookid,@PathVariable int chapterid){
        Book book = bookDao.findById(bookid).get();
        model.addAttribute("title",book.getTitle()+" : "+book.getChapters().get(chapterid).getName());
        model.addAttribute(book);
        model.addAttribute("chapter",book.getChapters().get(chapterid));
        model.addAttribute("fruits",book.getChapters().get(chapterid).getFruits());
        return "book/chapterview";
    }


    @RequestMapping(value = "fruit/{bookid}/{chapterid}/{fruitid}" , method = RequestMethod.GET)
    public String displayFruitViewForm(Model model, @PathVariable int bookid , @PathVariable int chapterid, @PathVariable int fruitid){
        Book book = bookDao.findById(bookid).get();
        model.addAttribute("title",book.getTitle()+" : "+book.getChapters().get(chapterid).getName()+" : "+book.getChapters().get(chapterid).getFruits().get(fruitid).getTitle());
        model.addAttribute(book);
        model.addAttribute("chapter",book.getChapters().get(chapterid));
        model.addAttribute("fruit",book.getChapters().get(chapterid).getFruits());
        return "book/fruitview";
    }


    @RequestMapping(value = "addfruit/{bookid}/{chapterid}", method = RequestMethod.GET)
    public String displayAddFruitForm(Model model, @PathVariable int bookid , @PathVariable int chapterid){
        Book book = bookDao.findById(bookid).get();
        Chapter currentChapter = null;
        for (Chapter chapter : book.getChapters()){
            System.out.println(chapter.getId()+" : chapter id");
            if (chapter.getId() == chapterid){
                currentChapter = chapter;
            }
        }
        model.addAttribute("title","Add a fruit to "+currentChapter.getName());
        model.addAttribute(book);
        model.addAttribute("chapter",currentChapter);
        model.addAttribute("afruit",new Fruit());
        return "book/addfruit";
    }

    @RequestMapping(value = "addfruit/{bookid}/{chapterid}", method = RequestMethod.POST)
    public String processAddFruitForm(Model model, @ModelAttribute @Valid Fruit newfruit, @PathVariable int bookid , @PathVariable int chapterid, Errors errors){
        Book book = bookDao.findById(bookid).get();
        if (errors.hasErrors()){
            model.addAttribute("title","Add a fruit to "+book.getChapters().get(chapterid).getName());
            model.addAttribute(book);
            model.addAttribute("chapter",book.getChapters().get(chapterid));
            return "book/addfruit";
        }
        fruitDao.save(newfruit);
        return "redirect:chapter/"+bookid+"/"+chapterid;
    }


//    TODO = create a fruit view form
//    TODO = create a comment processAddCommentForm


}
