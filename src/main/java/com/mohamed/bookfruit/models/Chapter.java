package com.mohamed.bookfruit.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Mohamed Mohamed
 */

@Entity
public class Chapter {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 1)
    private String name;

    @ManyToOne
    private Book book;

   @OneToMany
   @JoinColumn(name = "chapter_id")
    private List<Fruit> fruits;

    public Chapter(String name, Book book) {
        this.name = name;
        this.book = book;
    }

    public Chapter(){

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void addFruit(Fruit fruit){
        fruits.add(fruit);
    }

    public void removeFruit(Fruit fruit){
        fruits.remove(fruit);
    }


}
