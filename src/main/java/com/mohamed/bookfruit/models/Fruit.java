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
    @Size(min = 1,max = 50)
    private String title;

    @NotNull
    @Size(min=50)
    private long fruit;

    @ManyToOne
    private Chapter chapter;

    public Fruit(String title, long fruit, Chapter chapter){
        this.title = title;
        this.fruit = fruit;
        this.chapter = chapter;
    }

    public Fruit(){

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
