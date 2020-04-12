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

@Api(value = ApiSwaggerConstants.ACCESS_API_VALUE)
@RestController
@RequestMapping(value = "/api/access", produces = MediaType.ALL_VALUE)
@CrossOrigin
@RequiredArgsConstructor
public class AccessController {

    private final AccessService accessService;
    private final JavaMailSender javaMailSender;

    @ApiOperation(value = ApiSwaggerConstants.REGISTER_USER_OPERATION_VALUE,
            notes= ApiSwaggerConstants.REGISTER_USER_OPERATION_NOTE,
            response= User.class)
    @PostMapping(value = "/register", produces = "application/json")
    public User registerUser(@RequestBody User user) throws ServletException, UnsupportedEncodingException {
        return accessService.registerUser(user);
    }

    @ApiOperation(value = ApiSwaggerConstants.LOGIN_USER_OPERATION_VALUE,
            notes= ApiSwaggerConstants.LOGIN_USER_OPERATION_NOTE,
            response= String.class)
    @PostMapping(value = "/login", produces = "application/json")
    public String loginUser(@RequestBody User login) throws ServletException, UnsupportedEncodingException {
        return accessService.loginUser(login);
    }

    @ApiOperation(value = ApiSwaggerConstants.PASSWORD_RESET_SAVE_OPERATION_VALUE,
            notes= ApiSwaggerConstants.PASSWORD_RESET_SAVE_OPERATION_NOTE,
            response= User.class)
    @PostMapping(value = "/passwordResetSave", produces = "application/json")
    public User PasswordResetSave(@ModelAttribute User resetUser,
                                  @RequestParam String token) throws ServletException, UnsupportedEncodingException {
        return accessService.resetUser(resetUser, token);
    }

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