package web.dao;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<User> listUsers() {
        return entityManager.createQuery("select c from User c").getResultList();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        entityManager.createQuery("DELETE FROM User WHERE id = :idInjection")
                .setParameter("idInjection", id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void update(User user, Long id) {
        user.setId(id);
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public User show(Long id) {
        return listUsers()
                .stream()
                .filter(i -> i.getId().equals(id))
                .findAny()
                .orElse(null);
    }

}
