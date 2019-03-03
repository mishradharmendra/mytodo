package com.app.mytodo.mytodo.services.impl;

import com.app.mytodo.mytodo.dao.UserDao;
import com.app.mytodo.mytodo.models.User;
import com.app.mytodo.mytodo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public User findUserByUserName(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    @Transactional
    public User create(User user) {
        return userDao.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findUserByUserName(username);
    }
}
