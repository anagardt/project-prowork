package com.draganatasevska.finki.prowork.web.backend.service;

import com.draganatasevska.finki.prowork.web.backend.model.User;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.io.UnsupportedEncodingException;

@Service
public interface AccessService {
    User registerUser(User user) throws ServletException, UnsupportedEncodingException;

    User resetUser(User resetUser, String token) throws ServletException, UnsupportedEncodingException;

    User findUserByEmail(String email);

    String loginUser(User login) throws ServletException, UnsupportedEncodingException;

    String getUsernameFromJwtToken(String jwtToken);
}
