package com.simulator.services;

import com.simulator.modeld.UserKS;

import java.util.List;

public interface UserService {

    List<UserKS> listAll();

    UserKS getById(Long id);

    UserKS create(UserKS userKS);

    UserKS delete(Long id);

    UserKS saveOrUpdate(UserKS userKS);

    }


