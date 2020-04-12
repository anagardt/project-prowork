package com.draganatasevska.finki.prowork.web.backend.repository;

import com.draganatasevska.finki.prowork.web.backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, String> {
    User findByUsername(String username);

    User findByEmail(String email);
}