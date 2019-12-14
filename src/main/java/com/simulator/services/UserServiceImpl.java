package com.simulator.services;

import com.simulator.model.UserKS;
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
    public Long equalsUS(String log,String pass,List<UserKS> users) {

        for (int i = 0; i < users.size(); i++) {
            if ((log.equals(users.get(i).getLogin()))&&(pass.equals(users.get(i).getPassword()))) {
                return users.get(i).getId();
            }
        }
        return null;
    }

    @Override
    public boolean equals(String log,List<UserKS> users) {
        boolean flag = false;
        for (int i = 0; i < users.size(); i++) {
           if (log.equals(users.get(i).getLogin())) {
               flag = true;
               return flag;
           }
        }
        return flag;
    }

    @Override
    public boolean equals(String log,String pass,List<UserKS> users) {
        boolean flag = false;
        for (int i = 0; i < users.size(); i++) {
            if ((log.equals(users.get(i).getLogin()))&&(pass.equals(users.get(i).getPassword()))) {
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    @Override
    public UserKS getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserKS create(UserKS userKS) {
       // userKS.setDiff_id(DificultyServiceImpl.getD(1L));
        return userRepository.save(userKS);
    }

    @Override
    public UserKS delete(Long id) {
        userRepository.deleteById(id);
        return null;
    }

    @Override
    public UserKS saveOrUpdate(UserKS userKS) {
        return userRepository.save(userKS);
    }

}


