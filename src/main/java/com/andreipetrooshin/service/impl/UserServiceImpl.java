package com.andreipetrooshin.service.impl;

import com.andreipetrooshin.model.Role;
import com.andreipetrooshin.model.User;
import com.andreipetrooshin.repository.RoleDAO;
import com.andreipetrooshin.repository.UserDAO;
import com.andreipetrooshin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.findOne(1L));
        user.setRoles(roles);
        userDAO.save(user);

    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername("username");
    }
}
