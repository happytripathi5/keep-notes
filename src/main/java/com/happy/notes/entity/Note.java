//Step 1 — Create the Note Entity
//
//Your first goal is:
//
//Tell Spring/Hibernate what a Note looks like in the database.
//
//Create a Note class inside an entity package.
//
//The class should have 3 fields:
//
//id → uniquely identifies each note
//title → note title
//content → actual note content
//
//Then use JPA annotations to tell Hibernate:
//
//This class represents a database table.
//id is the primary key.
//id should be automatically generated.
//
//
//
//


package com.happy.notes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Note {

    @GeneratedValue
    @Id
    private Long id;
    private String title;
    private String content;
    private boolean completed;
    public Long getId(){
        return this.id;

    }
    public void setId(Long id){
        this.id=id;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title=title;
    }

    public String getContent(){
        return this.content;
    }
    public void setContent(String content){
        this.content= content;

    }

    //for setting iscompleted
    public void setCompleted(boolean completed){
        this.completed=completed;
    }

    //for getting iscompleted

    public boolean getCompleted(){
        return this.completed;
    }
}

