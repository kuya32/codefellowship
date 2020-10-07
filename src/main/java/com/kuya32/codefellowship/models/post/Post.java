package com.kuya32.codefellowship.models.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    long id;

    String body;
    Timestamp createdAt;

    public Post() {};

    public Post(String body, Timestamp createdAt) {
        this.body = body;
        this.createdAt = createdAt;
    }

    public String toString() {
        return String.format("%s\n Post made at %s", body, createdAt);
    }
}
