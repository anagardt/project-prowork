package com.draganatasevska.finki.prowork.web.backend.service.implementation;

import com.draganatasevska.finki.prowork.web.backend.model.User;
import com.draganatasevska.finki.prowork.web.backend.repository.UserDao;
import com.draganatasevska.finki.prowork.web.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * The implementation of @{@link UserService}
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public Iterable<User> getAllUsers() {
        return userDao.findAll();
    }
}