package com.makitoo.java.spring.controller;

import com.makitoo.java.spring.model.User;
import com.makitoo.java.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by mclement on 5/17/2016.
 */
@RequestMapping("/rest/users")
@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getAll(){
        return userService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") String id){
        return userService.retrieve(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User post(@RequestBody User user){
        return userService.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User put(@PathVariable("id") String id, @RequestBody User user){
        user.setId(id);
        return userService.update(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public User delete(@PathVariable("id") String id){
        return userService.delete(id);
    }

}
