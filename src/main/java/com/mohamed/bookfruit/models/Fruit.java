package com.mohamed.bookfruit.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Mohamed Mohamed
 */

@Entity
public class Fruit {

    @Id
    @GeneratedValue
    private int id;


    @NotNull
    @Size(min=1)
    private long fruit;

    @ManyToOne
    private Chapter chapter;

    public Fruit(long fruit, Chapter chapter){
        this.fruit = fruit;
        this.chapter = chapter;
    }

    public Fruit(){

    }

    public int getId() {
        return id;
    }

    public long getFruit() {
        return fruit;
    }

    public void setFruit(long fruit) {
        this.fruit = fruit;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }


}
