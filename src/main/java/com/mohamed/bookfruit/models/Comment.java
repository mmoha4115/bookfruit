package com.mohamed.bookfruit.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Mohamed Mohamed
 */

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 1,max = 50)
    private String title;

    @NotNull
    @Size(min=50)
    private String comment;

    @ManyToOne
    private Fruit fruit;

    public Comment(String title, String comment, Fruit fruit){
        this.title = title;
        this.comment = comment;
        this.fruit = fruit;
    }

    public Comment(){

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }



}
