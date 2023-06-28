package com.vishnugan.bookstore.entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    @Type ( type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime" )
    private DateTime createdAt;
    @Type ( type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime" )
    private DateTime updatedAt;

    public Author () {
    }

    public Author ( Long id, String name, String gender, DateTime createdAt, DateTime updatedAt ) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getGender () {
        return gender;
    }

    public void setGender ( String gender ) {
        this.gender = gender;
    }

    public DateTime getCreatedAt () {
        return createdAt;
    }

    public void setCreatedAt ( DateTime createdAt ) {
        this.createdAt = createdAt;
    }

    public DateTime getUpdatedAt () {
        return updatedAt;
    }

    public void setUpdatedAt ( DateTime updatedAt ) {
        this.updatedAt = updatedAt;
    }
}
