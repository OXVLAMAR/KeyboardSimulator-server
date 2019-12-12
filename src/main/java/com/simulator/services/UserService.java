package com.simulator.services;

import com.simulator.model.UserKS;

import java.util.List;

public interface UserService {

    List<UserKS> listAll();

    UserKS getById(Long id);

    UserKS create(UserKS userKS);

    UserKS delete(Long id);

    UserKS saveOrUpdate(UserKS userKS);

    boolean equals(String log,List<UserKS> users);

    boolean equals(String log,String pass,List<UserKS> users);

    Long equalsUS(String log,String pass,List<UserKS> users);

}


