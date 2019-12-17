package com.simulator.controllers;

import com.simulator.model.UserKS;
import com.simulator.services.DificultyServiceImpl;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<UserKS> listUser() {
        return userService.listAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public UserKS getUser(@PathVariable("id") Long id) {
        return userService.getById(Long.valueOf(id));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public UserKS saveOrUpdate(@RequestBody UserKS userKS) {
        if (userService.equals(userKS.getLogin(), userService.listAll())) {
            throw new IllegalArgumentException("Логин занят");
// return null; тут будет ошибка
        } else {
            return userService.saveOrUpdate(userKS);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = {"/registration/{login}/{password}"})
    public Long newUser(@PathVariable String login, @PathVariable String password) {
        if (userService.equals(login, userService.listAll())) {
            throw new IllegalArgumentException("Логин занят");
// return null; тут будет ошибка
        } else {
            UserKS userKS = new UserKS();
            userKS.setLogin(login);
            userKS.setPassword(password);
            userKS.setDiff_id(DificultyServiceImpl.getD(1L));
            userService.create(userKS);
            return userKS.getId();
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = {"/authorization/{login}/{password}"})
    public Long loginUser(@PathVariable String login, @PathVariable String password) {
        if (userService.equals(login, password, userService.listAll())) {
            return userService.equalsUS(login, password, userService.listAll());
        } else {
            throw new IllegalArgumentException("Неверные значения");
        }
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/{id}")
    public List<UserKS> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return userService.listAll();
    }
}

