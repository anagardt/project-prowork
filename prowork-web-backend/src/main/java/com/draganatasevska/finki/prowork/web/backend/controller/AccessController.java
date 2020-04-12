package com.draganatasevska.finki.prowork.web.backend.controller;

import com.draganatasevska.finki.prowork.web.backend.constants.ApiSwaggerConstants;
import com.draganatasevska.finki.prowork.web.backend.model.User;
import com.draganatasevska.finki.prowork.web.backend.service.AccessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.io.UnsupportedEncodingException;

/**
 *  Controller for the application access.
 */
@Api(value = ApiSwaggerConstants.ACCESS_API_VALUE)
@RestController
@RequestMapping(value = "/api/access", produces = MediaType.ALL_VALUE)
@CrossOrigin
@RequiredArgsConstructor
public class AccessController {

    private final AccessService accessService;
    private final JavaMailSender javaMailSender;

    /**
     * Register new user.
     * @param user the user that tries to register.
     *
     * @return {@link User} the registered user,
     * in case the registration is successful.
     * @throws ServletException,UnsupportedEncodingException
     * the exceptions that are thrown when the registration is not successful.
     */
    @ApiOperation(value = ApiSwaggerConstants.REGISTER_USER_OPERATION_VALUE,
            notes= ApiSwaggerConstants.REGISTER_USER_OPERATION_NOTE,
            response= User.class)
    @PostMapping(value = "/register", produces = "application/json")
    public User registerUser(@RequestBody User user) throws ServletException, UnsupportedEncodingException {
        return accessService.registerUser(user);
    }

    /**
     * Login of a new user.
     * @param login he user that tries to login.
     *
     * @return {@link User} the user that login successfully.
     * @throws ServletException,UnsupportedEncodingException
     * the exceptions that are thrown when the login is not successful.
     */
    @ApiOperation(value = ApiSwaggerConstants.LOGIN_USER_OPERATION_VALUE,
            notes= ApiSwaggerConstants.LOGIN_USER_OPERATION_NOTE,
            response= String.class)
    @PostMapping(value = "/login", produces = "application/json")
    public String loginUser(@RequestBody User login) throws ServletException, UnsupportedEncodingException {
        return accessService.loginUser(login);
    }

    /**
     * Process the user reset password request.
     * @param resetUser he user that tries to reset his/hers password.
     * @param token the jwt token that is send through email
     * when password reset is requested.
     *
     * @return {@link User} the user that tries to reset the password.
     */
    @ApiOperation(value = ApiSwaggerConstants.PASSWORD_RESET_SAVE_OPERATION_VALUE,
            notes= ApiSwaggerConstants.PASSWORD_RESET_SAVE_OPERATION_NOTE,
            response= User.class)
    @PostMapping(value = "/passwordResetSave", produces = "application/json")
    public User PasswordResetSave(@ModelAttribute User resetUser,
                                  @RequestParam String token) throws ServletException, UnsupportedEncodingException {
        return accessService.resetUser(resetUser, token);
    }

    /**
     * Sends the reset password jwt token through user's email.
     * @param email he email of the user that tries to reset
     * his/hers password.
     *
     * @return {@link User} the user that tries reset the password.
     */
    @ApiOperation(value = ApiSwaggerConstants.PASSWORD_RESET_OPERATION_VALUE,
            notes= ApiSwaggerConstants.PASSWORD_RESET_OPERATION_NOTE,
            response = User.class)
    @PostMapping(value = "/passwordReset", produces = "application/json")
    public User passwordReset(@RequestParam String email) {
        User existingUser = accessService.findUserByEmail(email);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Complete Password Reset!");
        mailMessage.setFrom("anagardtasevska@gmail.com");
        mailMessage.setText("To complete the password reset process, please click here: "
                + "http://localhost:4200/edit-user?token=" +
                existingUser.getResetToken());
        javaMailSender.send(mailMessage);
        return existingUser;
    }
}