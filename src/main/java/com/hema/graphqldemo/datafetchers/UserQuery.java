package com.hema.graphqldemo.datafetchers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hema.graphqldemo.entity.User;
import com.hema.graphqldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserQuery implements GraphQLQueryResolver {

    @Autowired
    private UserService userService;

    public User getUser(Long id){
        return userService.getUserById(id);
    }
}
