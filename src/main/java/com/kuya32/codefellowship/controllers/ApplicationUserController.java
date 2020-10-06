package com.kuya32.codefellowship.controllers;

import com.kuya32.codefellowship.models.user.ApplicationUser;
import com.kuya32.codefellowship.models.user.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/newUser")
    public RedirectView makeNewUser(String username, String password, String firstname,
                                    String lastname, String dateOfBirth, String bio) {
        System.out.println("Adding a new user!");
        password = passwordEncoder.encode(password);

        ApplicationUser newUser = new ApplicationUser(username, password, firstname, lastname,
                dateOfBirth, bio);

        applicationUserRepository.save(newUser);

        return new RedirectView("/login");
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
