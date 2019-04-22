package com.mohamed.bookfruit.controllers;

import com.mohamed.bookfruit.models.Author;
import com.mohamed.bookfruit.models.Book;
import com.mohamed.bookfruit.models.Chapter;
import com.mohamed.bookfruit.models.data.AidFunctions;
import com.mohamed.bookfruit.models.data.AuthorDao;
import com.mohamed.bookfruit.models.data.BookDao;
import com.mohamed.bookfruit.models.data.ChapterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    private ChapterDao chapterDao;

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
        Author newAuthor=new Author(authorname);
        for(Author anAuthor: authorDao.findAll()){
            if(anAuthor.equals(newAuthor)){
                newAuthor = anAuthor;
            }
        }
        authorDao.save(newAuthor);
        newBook.setAuthor(newAuthor);

        for (Book aBook : bookDao.findAll()) {
            if (aBook.equals(newBook)) {
                if (aBook.getChapters().size() > 1) {
                    model.addAttribute("book", aBook);
                    return "redirect:/book/"+aBook.getId();
                } if (aBook.getChapters().size()<1){
                    int id = aBook.getId();
                    return "redirect:search/addchapters/"+id;
                }
            }
        }
        bookDao.save(newBook);
        int id = newBook.getId();
        return "redirect:search/addchapters/"+id;
    }


    @RequestMapping(value = "addchapters/{id}" , method=RequestMethod.GET)
    public String displayAddChapterForm(Model model, @PathVariable int id){
        model.addAttribute("book",bookDao.findById(id).get());
        return "search/addChapters";
    }


    @RequestMapping(value = "addchapters/{id}" , method = RequestMethod.POST)
    public String processAddChaptersForm(Model model, @RequestParam List<String> chapters, @PathVariable int id){

        Book currentBook = bookDao.findById(id).get();
        for(String chapter : chapters){
            if (!chapter.isEmpty()){
                Chapter chapter1 = new Chapter(chapter,currentBook);
                chapterDao.save(chapter1);
                currentBook.addChapter(chapter1);
            }
        }

        bookDao.save(currentBook);
        model.addAttribute("book",currentBook);

        return "redirect:/book/"+currentBook.getId();
    }



}
