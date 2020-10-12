package com.kuya32.codefellowship.controllers;

import com.kuya32.codefellowship.models.user.ApplicationUser;
import com.kuya32.codefellowship.models.user.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;


@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signup")
    public String showSignup(Model m, Principal principal) {
        m.addAttribute("principle", principal);
        return"signup";
    }

    @PostMapping("/signup")
    public RedirectView signupNewUser(String username, String password, String firstname,
                                    String lastname, String dateOfBirth, String bio,
                                      String profilePicUrl) throws Exception {
        System.out.println("Adding a new user!");
        password = passwordEncoder.encode(password);
        ApplicationUser newUser = new ApplicationUser(username, password, firstname, lastname,
                dateOfBirth, bio, profilePicUrl);

        applicationUserRepository.save(newUser);

        return new RedirectView("/login");
    }

    @GetMapping("/login")
    public String login(Model m, Principal principal) {
        System.out.println("Logging in user");
        m.addAttribute("principal", principal);
        return "login";
    }

    @GetMapping("/users")
    public String showUsers(Model m, Principal principal) {
        System.out.println("Checking out users");
        ApplicationUser users = applicationUserRepository.findByUsername(principal.getName());
        List<ApplicationUser> allUsers = applicationUserRepository.findAll();
        m.addAttribute("users", users);
        m.addAttribute("principal", principal);
        m.addAttribute("allUsers", allUsers);
        return "users";
    }

    @GetMapping("/user/{id}")
    public String showSingleUser(Model m, Principal principal, @PathVariable long id) {
        System.out.println("Routing to users");
        ApplicationUser user = applicationUserRepository.getOne(id);
        ApplicationUser principleUser =
                applicationUserRepository.findByUsername(principal.getName());
        m.addAttribute("user", user);
        m.addAttribute("principal", principal);
        m.addAttribute("principalUser", principleUser);
        return "user";
    }

    @GetMapping("/myprofile")
    public String showMyProfile(Model m, Principal principal) {
        ApplicationUser user = applicationUserRepository.findByUsername(principal.getName());
        m.addAttribute("user", user);
        m.addAttribute("principle", principal);
        return "myprofile";
    }

    @PostMapping("/homies")
    public RedirectView followedUser(Principal principal, Long id) {
        ApplicationUser followedUser = applicationUserRepository.getOne(id);
        ApplicationUser sheep = applicationUserRepository.findByUsername(principal.getName());
        followedUser.getFollower(sheep);
        sheep.follow(followedUser);
        applicationUserRepository.save(followedUser);
        applicationUserRepository.save(sheep);
        return new RedirectView("/user/" + id);
    }

    @PostMapping("/nothomies")
    public RedirectView unfollowedUser(Principal principal, Long id) {
        ApplicationUser unfollowedUser = applicationUserRepository.getOne(id);
        ApplicationUser sheep = applicationUserRepository.findByUsername(principal.getName());
        unfollowedUser.removeFollower(sheep);
        sheep.removeFollow(unfollowedUser);
        applicationUserRepository.save(unfollowedUser);
        applicationUserRepository.save(sheep);
        return new RedirectView("/user/" + id);
    }
}
