package com.gosiewski.taxiapp.repository;

import com.gosiewski.taxiapp.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientsRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
