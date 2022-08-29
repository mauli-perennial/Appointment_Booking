package com.appointemnt.perennial.service;

import com.appointemnt.perennial.dao.UserRepository;
import com.appointemnt.perennial.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public String registerUser(User user) {
        userRepository.save(user);
        return "user registration succssfull";
    }
}
