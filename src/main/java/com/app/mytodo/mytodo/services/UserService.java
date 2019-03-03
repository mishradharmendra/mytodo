package com.app.mytodo.mytodo.services;

import com.app.mytodo.mytodo.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findUserByUserName(String username);

    User create(User user);

}
