package com.simulator.services;
import com.simulator.modeld.UserKS;
import com.simulator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public List<UserKS> listAll() {
        List<UserKS> userks = new ArrayList<>();
        userRepository.findAll().forEach(userks::add);
        return userks;
    }

    @Override
    public UserKS getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserKS create(UserKS userKS) {
        return userRepository.save(userKS);
    }

    @Override
    public UserKS delete(Long id) {
        userRepository.deleteById(id);
        return null;
    }
    @Override
    public UserKS saveOrUpdate(UserKS userKS)
    {
        return userRepository.save(userKS);
    }

}


