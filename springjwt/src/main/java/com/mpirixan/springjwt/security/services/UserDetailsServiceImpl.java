package com.mpirixan.springjwt.security.services;


import com.mpirixan.springjwt.models.User;
import com.mpirixan.springjwt.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

}
