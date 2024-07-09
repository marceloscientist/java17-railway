package com.santander.challenge.service;

import com.santander.challenge.model.User;

public interface IUserService {
    User findById(Long id);
    User create(User userToCreate);
}
