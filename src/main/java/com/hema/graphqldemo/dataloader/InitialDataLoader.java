package com.hema.graphqldemo.dataloader;

import com.hema.graphqldemo.entity.User;
import com.hema.graphqldemo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitialDataLoader {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void loadData() {
        List<User> users = new ArrayList<>();
        users.add(User.builder().name("John").email("abc@gmail.com").organization("Chase").build());
        users.add(User.builder().name("Doe").email("bcd@gmail.com").organization("BOA").build());
        users.add(User.builder().name("Jane").email("cde@gmail.com").organization("WellsFargo").build());
        users = userRepository.saveAll(users);
        users.forEach( u -> System.out.println(u.getId()));

    }
}
