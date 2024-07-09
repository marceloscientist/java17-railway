package com.santander.challenge.controller;

import com.santander.challenge.model.User;
import com.santander.challenge.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")

public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> buscarUsuarioPorId(@PathVariable("id") Long id) {
        User user = this.userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> criarUsuarioPorId(@RequestBody User userToCreate) {
        User userCreated = this.userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.id())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }
}
