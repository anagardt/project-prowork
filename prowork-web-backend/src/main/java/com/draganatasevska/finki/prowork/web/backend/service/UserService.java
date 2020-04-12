package com.draganatasevska.finki.prowork.web.backend.service;

import com.draganatasevska.finki.prowork.web.backend.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Iterable<User> getAllUsers();
}
