package com.zipcodewilmington.angularservice.controller;

import com.zipcodewilmington.angularservice.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 12/20/17.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/users")
public class UserController {
    private List<User> users = new ArrayList<>();

    public UserController() {
        this.users = buildUsers();
    }



    @RequestMapping(method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        user.setId(getNextId());
        this.users.add(user);
        return user;
    }









    // ================================================ PRIVATE METHODS ================================================

    private Long getNextId() {
        Long nextId = 0L;
        if (this.users.size() != 0) {
            User lastUser = this.users.stream().skip(this.users.size() - 1).findFirst().orElse(null);
            nextId = lastUser.getId() + 1;
        }
        return nextId;
    }

    private List<User> buildUsers() {
        List<User> users = new ArrayList<>();
        Arrays.asList(
                buildUser(1L, "John"),
                buildUser(2L, "Jon"),
                buildUser(3L, "Will"),
                buildUser(4L, "Sam"),
                buildUser(5L, "Ross"));

        return users;
    }

    private User buildUser(Long id, String fname) {
        // TODO - Implement logging
        return new User(id, fname);
    }
}
