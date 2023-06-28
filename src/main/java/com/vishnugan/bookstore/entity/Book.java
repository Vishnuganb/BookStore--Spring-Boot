package com.vishnugan.bookstore.entity;
// spring jpa hibernate ai use panuthu hibernate vanthu oru ORM tool
// ORM tool is used to map the java object to the database table
// java lai ellame object ai irukum database lai athai epidi oru column lai map aki epidi store panurathu athe store
// akina value ai epidi retreive panni eduthudu vaarathu endurathu thaan intha ORM tool(hibernate) ai use panurathu

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "description")
    private String desc;
    private Integer yearOfPublication;
    private String bookType;

    public Book ( Long id, String name, String desc, Integer yearOfPublication, String bookType ) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.yearOfPublication = yearOfPublication;
        this.bookType = bookType;
    }

    public Book () {

    }

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getDesc () {
        return desc;
    }

    public void setDesc ( String desc ) {
        this.desc = desc;
    }

    public Integer getYearOfPublication () {
        return yearOfPublication;
    }

    public void setYearOfPublication ( Integer yearOfPublication ) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getBookType () {
        return bookType;
    }

    public void setBookType ( String bookType ) {
        this.bookType = bookType;
    }
}
