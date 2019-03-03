package com.app.mytodo.mytodo.dao;

import com.app.mytodo.mytodo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {
    User findUserByUsername(String username);
}
