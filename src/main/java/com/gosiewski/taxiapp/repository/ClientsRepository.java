package com.gosiewski.taxiapp.repository;

import com.gosiewski.taxiapp.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientsRepository extends CrudRepository<Client, Long> {
    Optional<Client> getClientByUsername(String username);
}
