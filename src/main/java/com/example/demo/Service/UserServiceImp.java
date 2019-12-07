package com.example.demo.Service;


import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImp  implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getUsers() {
        List<User> users=new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public void updateUser(Long id, User user) {
        User u=userRepository.findById(id).get();
        u.setName(user.getName());
        userRepository.save(u);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}
