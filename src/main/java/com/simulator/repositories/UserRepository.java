package com.simulator.repositories;

import com.simulator.modeld.UserKS;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserKS, Long> {
}
