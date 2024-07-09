package com.santander.challenge.service;

import com.santander.challenge.model.User;
import com.santander.challenge.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userToCreate.id() != null && this.userRepository.existsById(userToCreate.id())) {
            throw new IllegalArgumentException("This ID has already been used");
        }

        if(this.userRepository.existsByAccountNumber(userToCreate.account().number())) {
            throw new IllegalArgumentException("This Account Number has already been used");
        }

        return this.userRepository.save(userToCreate);
    }
}
