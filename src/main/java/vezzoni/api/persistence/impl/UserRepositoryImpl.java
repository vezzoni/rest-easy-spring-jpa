package vezzoni.api.persistence.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vezzoni.api.model.User;
import vezzoni.api.persistence.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public User get(String username) {
        
        User user = null;
        
        List<User> users = this
                .entityManager
                .createQuery("SELECT u FROM User u WHERE u.username = ?")
                .setParameter(1, username)
                .getResultList();

        if (users != null && !users.isEmpty()) {
            user = users.get(0);
        }

        return user;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public User save(User user) {
        User u = this.entityManager.merge(user);
        this.entityManager.flush();

        return u;
    }
    
}
