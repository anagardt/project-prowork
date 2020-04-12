package com.draganatasevska.finki.prowork.web.backend.service.implementation;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.draganatasevska.finki.prowork.web.backend.model.User;
import com.draganatasevska.finki.prowork.web.backend.repository.UserDao;
import com.draganatasevska.finki.prowork.web.backend.service.AccessService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AccessServiceImpl implements AccessService {

    private final UserDao userDao;

    @Override
    public User registerUser(User user) throws ServletException, UnsupportedEncodingException {
        user.setDateCreated(new Date());
        User userByUsername = userDao.findByUsername(user.getUsername());
        User userByEmail = userDao.findByEmail(user.getEmail());
        if (userByUsername != null) {
            throw new ServletException("Username is already taken");
        } else if (userByEmail != null) {
            throw new ServletException("Email is already taken");
        } else {
            String plain = user.getPassword();
            String hashed = BCrypt.hashpw(plain, BCrypt.gensalt());
            user.setPassword(hashed);
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String jwtToken = JWT.create()
                    .withIssuer("prowork")
                    .withIssuedAt(new Date())
                    .withClaim("username", user.getUsername())
                    .sign(algorithm);
            user.setResetToken(jwtToken);
            return userDao.save(user);
        }
    }

    @Override
    public User resetUser(User resetUser, String token) throws ServletException, UnsupportedEncodingException {
        resetUser.setDateCreated(new Date());
        User userByUsername = userDao.findByUsername(resetUser.getUsername());
        if (userByUsername == null) {
            throw new ServletException("Username doesn't exist");
        }
        if (!userByUsername.getResetToken().equals(token))
        {
            throw new ServletException("Token not valid.");
        }
        else {
            String plain = resetUser.getPassword();
            String hashed = BCrypt.hashpw(plain, BCrypt.gensalt());
            userByUsername.setPassword(hashed);
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String jwtToken = JWT.create()
                    .withIssuer("prowork")
                    .withIssuedAt(new Date())
                    .withClaim("username", userByUsername.getUsername())
                    .sign(algorithm);
            userByUsername.setResetToken(jwtToken);
            return userDao.save(userByUsername);
        }
    }

    @Override
    public User findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public String loginUser(User login) throws ServletException, UnsupportedEncodingException {
        String jwtToken = "";
        String username = login.getUsername();
        String plainPassword = login.getPassword();
        if (username == null || username.trim().equals("") || plainPassword  == null) {
            throw new ServletException("Please fill in username and password");
        }
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new ServletException("No such user");
        } else {
            String hashed = user.getPassword();
            if (!BCrypt.checkpw(plainPassword, hashed)) {
                throw new ServletException("Wrong password");
            } else {
                Algorithm algorithm = Algorithm.HMAC256("secret");
                jwtToken = JWT.create()
                        .withIssuer("prowork")
                        .withIssuedAt(new Date())
                        .withClaim("username", username)
                        .sign(algorithm);
            }
        }
        return jwtToken;
    }

    @Override
    public String getUsernameFromJwtToken(String jwtToken) {
        DecodedJWT jwt = JWT.decode(jwtToken);
        Claim username = jwt.getClaim("username");
        return username.asString();
    }
}
