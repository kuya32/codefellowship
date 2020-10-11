package com.kuya32.codefellowship.controllers;

import com.kuya32.codefellowship.models.post.Post;
import com.kuya32.codefellowship.models.post.PostRepository;
import com.kuya32.codefellowship.models.user.ApplicationUser;
import com.kuya32.codefellowship.models.user.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class PostController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PostRepository postRepository;

    @PostMapping("/post")
    public RedirectView createPost(Principal principal, String body) {
        ApplicationUser user = applicationUserRepository.findByUsername(principal.getName());
        Post post = new Post(user, body);
        postRepository.save(post);
        return new RedirectView("/myprofile");
    }
}
