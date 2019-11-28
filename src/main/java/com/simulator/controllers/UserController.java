package com.simulator.controllers;

import com.simulator.modeld.UserKS;
import com.simulator.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping({"/userKS"})
@RestController

public class UserController  {
    private UserService userService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<UserKS> listUser(){
        return userService.listAll();
    }

    @GetMapping(path ="/{id}")
    public UserKS getUser(@PathVariable("id") Long id){
        return  userService.getById(Long.valueOf(id));
    }


    @PutMapping
    public UserKS saveOrUpdate(@RequestBody UserKS userKS)
    {

        return  userService.saveOrUpdate(userKS);
    }

    @PostMapping
    public UserKS newUser(@RequestBody UserKS userKS)
    {
        return userService.create(userKS);
    }


    @DeleteMapping(path ="/{id}")
    public UserKS delete(@PathVariable("id") Long id){
        return userService.delete(Long.valueOf(id));
    }
}

