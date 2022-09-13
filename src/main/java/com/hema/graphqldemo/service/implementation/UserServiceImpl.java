package com.hema.graphqldemo.service.implementation;

import com.hema.graphqldemo.entity.User;
import com.hema.graphqldemo.exception.UserNotFoundException;
import com.hema.graphqldemo.repo.UserRepository;
import com.hema.graphqldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        try {
            return user.get();
        }catch (NoSuchElementException ex) {
            System.out.println("User with given id doesn't exist");
            throw new UserNotFoundException("User with given id doesn't exist", "id");
        }
    }

    @Override
    public User createUser(String name, String organization, String email) {
        User user = User.builder().name(name).organization(organization).email(email).build();
        return userRepo.save(user);
    }
}
