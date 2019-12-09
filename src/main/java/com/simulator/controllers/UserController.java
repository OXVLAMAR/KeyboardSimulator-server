package com.simulator.controllers;

import com.simulator.model.UserKS;
import com.simulator.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping({"/userKS"})
@RestController

public class UserController {
    private UserService userService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<UserKS> listUser() {
        return userService.listAll();
    }

    @GetMapping(path = "/{id}")
    public UserKS getUser(@PathVariable("id") Long id)  {
        return userService.getById(Long.valueOf(id));
    }


    @PutMapping
    public UserKS saveOrUpdate(@RequestBody UserKS userKS) {

        return userService.saveOrUpdate(userKS);
    }

    @PostMapping (path = {"/newUser"})
    public UserKS newUser(@RequestBody UserKS userKS) {
        if (userService.equals(userKS, userService.listAll())) {
            throw new IllegalArgumentException("Логин занят");
           // return null; тут будет ошибка
        } else {
            return userService.create(userKS);
        }
    }

    @PostMapping (path = {"/loginUser"})
    public String loginUser(@RequestBody UserKS userKS) {
        if (userService.equals(userKS.getLogin(), userKS.getPassword(), userService.listAll())) {
            return "/userKS/menu";
        } else {
            throw new IllegalArgumentException("Неверные значения");
        }
    }


    @DeleteMapping(path = "/{id}")
    public UserKS delete(@PathVariable("id") Long id) {
        return userService.delete(Long.valueOf(id));
    }
}

