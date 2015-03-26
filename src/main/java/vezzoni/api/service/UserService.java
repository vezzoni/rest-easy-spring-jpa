package vezzoni.api.service;

import vezzoni.api.model.User;

public interface UserService {

    User get(String username);
    
    User save(User user);

}
