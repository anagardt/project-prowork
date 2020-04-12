package com.draganatasevska.finki.prowork.web.backend.service;

import com.draganatasevska.finki.prowork.web.backend.model.User;
import org.springframework.stereotype.Service;

/**
 * Service used to provide the user functionality.
 */
@Service
public interface UserService {

    /**
     * Returns the list of all users.
     *
     * @return {@link Iterable<User>} the list of users.
     */
    Iterable<User> getAllUsers();
}
