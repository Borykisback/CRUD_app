package web.dao;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    public void update(Long id, String name, String lastName, int age) {
        entityManager.createQuery("UPDATE User SET firstName = ?1, lastName = ?2, age = ?3 WHERE id = ?4")
                .setParameter(1, name)
                .setParameter(2, lastName)
                .setParameter(3, age)
                .setParameter(4, id)
                .executeUpdate();
    }

}
