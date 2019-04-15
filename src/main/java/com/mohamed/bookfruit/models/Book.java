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
    @NotNull
    @Size(min = 9,max = 20)
    @ISBN
    private String isbn13;

    @NotNull
    @Size(min = 1)
    private String title;

    @ManyToOne
    private Author author;

    @NotNull
    @Size(min = 1)
    private String image;



    @OneToMany
    @JoinColumn(name = "book_isbn13")
    private List<Chapter> chapters;

    public Book(String title,String image, String isbn13){
        this.title = title;
        this.image = image;
        this.isbn13 = isbn13;
    }

    public Book(){

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

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public void addChapter(Chapter chapter){
        chapters.add(chapter);
    }

    public void removeChapter(Chapter chapter){
        chapters.remove(chapter);
    }

}
