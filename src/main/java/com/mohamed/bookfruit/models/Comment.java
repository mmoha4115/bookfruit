package com.mohamed.bookfruit.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Mohamed Mohamed
 */

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


}
