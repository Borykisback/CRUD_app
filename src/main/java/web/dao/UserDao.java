package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    void delete(Long id);
    void update(Long id, String name, String lastName, int age);
}
