package com.draganatasevska.finki.prowork.web.backend.controller;

import com.draganatasevska.finki.prowork.web.backend.constants.ApiSwaggerConstants;
import com.draganatasevska.finki.prowork.web.backend.model.User;
import com.draganatasevska.finki.prowork.web.backend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = ApiSwaggerConstants.USER_API_VALUE)
@RestController
@RequestMapping(value = "/api/user", produces = MediaType.ALL_VALUE)
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @ApiOperation(value = ApiSwaggerConstants.ALL_USERS_OPERATION_VALUE,
            notes= ApiSwaggerConstants.ALL_USERS_OPERATION_NOTE,
            response= Iterable.class)
    @GetMapping(value = "/getAll", produces = "application/json")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
