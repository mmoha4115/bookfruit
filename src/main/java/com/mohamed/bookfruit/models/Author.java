package com.mohamed.bookfruit.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

/**
 * Created by Mohamed Mohamed
 */

@Entity
public class Author {
    @Column(unique = true)
    @GeneratedValue
    private int id;

    @Id
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

    public List<Book> getBooks(){
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return getName().equals(author.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), books.size());
    }
}
