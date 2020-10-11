package com.kuya32.codefellowship.models.user;

import com.kuya32.codefellowship.models.post.Post;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @OneToMany(mappedBy = "applicationUser", cascade = CascadeType.ALL)
    List<Post> posts = new ArrayList<>();

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String dateOfBirth;
    String bio;
    String profilePicUrl = "https://moonvillageassociation.org/wp-content/uploads/2018/06/default-profile-picture1.jpg";

    public ApplicationUser() {};

    public ApplicationUser(String username, String password, String firstname,
                           String lastname, String dateOfBirth, String bio, String profilePicUrl) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
        this.profilePicUrl = profilePicUrl;
    }

    public long getId() {
        return id;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
