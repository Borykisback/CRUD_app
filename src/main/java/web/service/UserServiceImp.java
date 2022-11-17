package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
      return userDao.listUsers();
//        List<User> userList = userDao.listUsers();
//        userList.forEach(i -> System.out.printf(" ID: %s%n Name: %s%n LastName: %s%n",
//                i.getId(), i.getFirstName(), i.getLastName()));
//        return userList;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void update(Long id, String name, String lastName, int age) {
        userDao.update(id, name, lastName, age);
    }

}
