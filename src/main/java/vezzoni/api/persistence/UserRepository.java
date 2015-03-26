package vezzoni.api.persistence;

import vezzoni.api.model.User;

public interface UserRepository {
    
    User get(String username);
    
    User save(User user);

}
