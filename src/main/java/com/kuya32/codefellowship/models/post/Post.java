package com.kuya32.codefellowship.models.post;

import com.kuya32.codefellowship.models.user.ApplicationUser;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    ApplicationUser applicationUser;

    String body;
    Date createdAt;

    public Post() {};

    public Post(ApplicationUser applicationUser, String body) {
        this.applicationUser = applicationUser;
        this.body = body;
        // Used SimpleDataFormat from https://stackoverflow.com/questions/1156468/how-to-format-a-java-sql-timestamp-for-displaying
        this.createdAt = new Date(Calendar.getInstance().getTime().getTime());
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
