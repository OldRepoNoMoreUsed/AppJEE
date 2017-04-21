package app.services;

import app.models.User;

import java.util.List;

public interface UserService{
    boolean authenticate(String username, String password);
    boolean register(String username, String password, String email);

    List<User> findAll();
    User findById(Long id);
    User create(User user);
    User edit(User user);
    void deleteById(Long id);
}