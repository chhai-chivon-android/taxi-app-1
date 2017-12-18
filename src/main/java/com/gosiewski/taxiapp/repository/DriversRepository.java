package com.gosiewski.taxiapp.repository;

import com.gosiewski.taxiapp.model.Driver;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DriversRepository extends CrudRepository<Driver, Long> {
    Optional<Driver> findByUsername(String username);
}
