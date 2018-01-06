package com.gosiewski.taxiapp.controller;

import com.gosiewski.taxiapp.dto.RegistrationDto;
import com.gosiewski.taxiapp.model.Role;
import com.gosiewski.taxiapp.model.User;
import com.gosiewski.taxiapp.repository.UsersRepository;
import com.gosiewski.taxiapp.repository.RolesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class RegistrationController {
    private final UsersRepository usersRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UsersRepository usersRepository, RolesRepository rolesRepository,
                                  PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.rolesRepository = rolesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<User> register(@RequestBody RegistrationDto registrationDto) {
        if (registrationDto.username == null || registrationDto.username.length() < 3)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (registrationDto.password == null || registrationDto.password.length() < 6)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (usersRepository.findByUsername(registrationDto.username).isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        String passwordHash = passwordEncoder.encode(registrationDto.password);
        Role role = rolesRepository.findOne(1L);
        User userToBeSaved = new User(registrationDto.username, passwordHash, Collections.singletonList(role));

        User savedUser = usersRepository.save(userToBeSaved);

        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }
}
