package com.draganatasevska.finki.prowork.web.backend.service;

import com.draganatasevska.finki.prowork.web.backend.model.User;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.io.UnsupportedEncodingException;

/**
 * Service used to provide the access functionality.
 */
@Service
public interface AccessService {

    /**
     * Register new user.
     * @param user the user that tries to register.
     *
     * @return {@link User} the registered user,
     * in case the registration is successful.
     * @throws ServletException,UnsupportedEncodingException
     * the exceptions that are thrown when the registration is not successful.
     */
    User registerUser(User user) throws ServletException, UnsupportedEncodingException;

    /**
     * Process the user reset password request.
     * @param resetUser he user that tries to reset his/hers password.
     * @param token the jwt token that is send through email
     * when password reset is requested.
     *
     * @return {@link User} the user that tries to reset the password.
     */
    User resetUser(User resetUser, String token) throws ServletException, UnsupportedEncodingException;

    /**
     * Login of a new user.
     * @param login he user that tries to login.
     *
     * @return {@link User} the user that login successfully.
     * @throws ServletException,UnsupportedEncodingException
     * the exceptions that are thrown when the login is not successful.
     */
    String loginUser(User login) throws ServletException, UnsupportedEncodingException;

    /**
     * Find the user with the provided email.
     * @param email the email by which the user
     * is uniquely identified
     *
     * @return {@link User} the user
     */
    User findUserByEmail(String email);

    /**
     * Find the user with the provided jwtToken.
     * @param jwtToken the jwtToken by which the user
     * is uniquely identified
     *
     * @return {@link User} the user
     */
    String getUsernameFromJwtToken(String jwtToken);
}
