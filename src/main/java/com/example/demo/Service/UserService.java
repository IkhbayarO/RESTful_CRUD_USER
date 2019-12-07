package com.example.demo.Service;

import com.example.demo.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public List<User> getUsers();
    public User getUser(Long id);
    public void deleteUser(Long id);
    public void addUser(User user);
    public void updateUser(Long id, User user);
}
