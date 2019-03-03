package com.betterfly.springbootmvc.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by betterfly
 * Date : 2019.03.03
 */

@RestController
public class UserController {
    @PostMapping("/users/create")
    public User create(@RequestBody User user){
        return user;
    }
}
