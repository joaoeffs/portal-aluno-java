package com.joaoeffs.portalalunojava.infra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.joaoeffs.portalalunojava.core.domain.aluno.repository.AlunoDomainRepository;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private AlunoDomainRepository repository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return repository.findByEmail(username);
    }
}
