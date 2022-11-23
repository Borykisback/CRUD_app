package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void delete(Long id);
    void update(User user, Long id);
    User show(Long id);
}
