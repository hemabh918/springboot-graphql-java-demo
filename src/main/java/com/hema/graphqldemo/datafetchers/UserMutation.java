package com.hema.graphqldemo.datafetchers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hema.graphqldemo.entity.User;
import com.hema.graphqldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMutation implements GraphQLMutationResolver {
    @Autowired
    private UserService userService;

    public User createUser(String name, String organization, String email) {
       return userService.createUser(name, organization, email);
    }
}
