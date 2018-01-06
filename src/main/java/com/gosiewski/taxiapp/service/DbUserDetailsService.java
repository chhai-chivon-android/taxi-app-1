package com.gosiewski.taxiapp.service;

import com.gosiewski.taxiapp.model.User;
import com.gosiewski.taxiapp.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public final class DbUserDetailsService implements UserDetailsService {

    @Autowired
    private ClientsRepository clientsRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = clientsRepository.findByUsername(s);

        if (!user.isPresent())
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.get().getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));

        return new org.springframework.security.core.userdetails.User(user.get().getUsername(),
                user.get().getPasswordHash(), authorities);
    }
}
