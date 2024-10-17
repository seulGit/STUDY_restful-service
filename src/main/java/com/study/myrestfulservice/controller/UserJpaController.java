package com.study.myrestfulservice.controller;

import com.study.myrestfulservice.bean.User;
import com.study.myrestfulservice.exception.UserNotFoundException;
import com.study.myrestfulservice.repository.UserRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/jpa")
public class UserJpaController {

    private UserRepository userRepository;

    public UserJpaController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // /jpa/users
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    // /Jpa/users/{id}
    @GetMapping("/users/{id}")
    public ResponseEntity retrieveUsers(@PathVariable int id)  {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            throw new UserNotFoundException("id-" + id);
        }

        EntityModel entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder linTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(linTo.withRel("all-users"));

        return ResponseEntity.ok(entityModel);
    }
}
