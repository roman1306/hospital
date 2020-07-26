package com.github.roman1306.registry.service;

import com.github.roman1306.registry.dao.UserDao;
import com.github.roman1306.registry.entity.Role;
import com.github.roman1306.registry.entity.User;
import com.github.roman1306.registry.exception.UserAlreadyExistsException;
import com.github.roman1306.registry.service.spi.UserService;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultUserService implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public DefaultUserService(
            @NonNull UserDao userDao,
            @NonNull PasswordEncoder passwordEncoder
    ) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @NonNull
    @Transactional
    public User register(User user) {
        final User existsUser = this.userDao.loadUserByUsername(user.getUsername());
        if (existsUser != null) {
            throw  new UserAlreadyExistsException(user.getUsername());
        }
        String encodedPassword = this.passwordEncoder.encode(user.getPassword());
        User currentUser = user.setPassword(encodedPassword);
        return this.userDao.createUser(currentUser);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> getRoles() {
        return this.userDao.getRoles();
    }
}
