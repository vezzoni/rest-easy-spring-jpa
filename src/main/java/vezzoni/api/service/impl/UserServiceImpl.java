package vezzoni.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vezzoni.api.model.User;
import vezzoni.api.persistence.UserRepository;
import vezzoni.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    
    @Override
    public User get(String username) {
        return repository.get(username);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }
    
}
