package com.kuya32.codefellowship.models.post;

import com.kuya32.codefellowship.models.user.ApplicationUser;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    long id;

    @ManyToOne
    ApplicationUser applicationUser;

    String body;
    Timestamp createdAt;

    public Post() {};

    public Post(ApplicationUser applicationUser, String body, Timestamp createdAt) {
        this.applicationUser = applicationUser;
        this.body = body;
        this.createdAt = createdAt;
    }

    // This makes a string of the post
    public String toString() {
        return String.format("%s\n Post made at %s", body, createdAt);
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
