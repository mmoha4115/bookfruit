package com.mohamed.bookfruit.models;


import org.hibernate.validator.constraints.ISBN;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Mohamed Mohamed
 */

@Entity
public class Book {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 1)
    private String title;

    @ManyToOne
    private Author author;

    @NotNull
    @Size(min = 1)
    private String image;

    @NotNull
    @Size(min = 9,max = 20)
    @ISBN
    private String isbn;

    @OneToMany
    @JoinColumn(name = "book_id")
    private List<Chapter> chapters;

    public Book(String title,Author author, String image, String isbn){
        this.title = title;
        this.author = author;
        this.image = image;
        this.isbn = isbn;
    }

    public Book(){

    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void addChapter(Chapter chapter){
        chapters.add(chapter);
    }

    public void removeChapter(Chapter chapter){
        chapters.remove(chapter);
    }

}
