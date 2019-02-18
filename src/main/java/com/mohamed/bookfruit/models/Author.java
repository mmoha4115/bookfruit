package com.mohamed.bookfruit.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Mohamed Mohamed
 */

@Entity
public class Author {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 1)
    private String name;

    @OneToMany
    @JoinColumn(name = "author_id")
    private List<Book> books;

    public Author(String name){
        this.name = name;
    }

    public Author(){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }

}
