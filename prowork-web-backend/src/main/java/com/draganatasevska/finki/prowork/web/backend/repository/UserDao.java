package com.draganatasevska.finki.prowork.web.backend.repository;

import com.draganatasevska.finki.prowork.web.backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 * Dao used for user data.
 */
@Repository
public interface UserDao extends CrudRepository<User, String> {

    /**
     * Find user by the username provided.
     * @param username the username
     *
     * @return {@link User}
     */
    User findByUsername(String username);

    /**
     * Find user by the email provided.
     * @param email the email.
     *
     * @return {@link User}
     */
    User findByEmail(String email);
}