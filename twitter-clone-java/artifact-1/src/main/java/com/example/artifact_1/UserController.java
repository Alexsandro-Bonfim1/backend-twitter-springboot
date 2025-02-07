package com.example.artifact_1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<String> users = new ArrayList<>();

    @GetMapping
    public List<String> getAllUsers() {
        return users;
    }

    @PostMapping
    public void createUser(@RequestBody String user) {
        users.add(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody String user) {
        if (id >= 0 && id < users.size()) {
            users.set(id, user);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        if (id >= 0 && id < users.size()) {
            users.remove(id);
        }
    }
}