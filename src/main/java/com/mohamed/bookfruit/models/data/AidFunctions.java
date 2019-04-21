package com.mohamed.bookfruit.models.data;

import com.mohamed.bookfruit.models.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AidFunctions {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private ChapterDao chapterDao;
    @Autowired
    private FruitDao fruitDao;


    public Book findbookbyid(int id){
        Optional<Book> findBook = bookDao.findById(id);
        for(Book abook : bookDao.findAll()){
            if (abook.getId() == id){
                findBook = Optional.of(abook);
            }
        }
        Book foundBook = findBook.get();
        return foundBook;
    }



}
