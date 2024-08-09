package com.athem.cms.service.cms_service.service;

import com.athem.cms.service.cms_service.dtos.LoginUserDto;
import com.athem.cms.service.cms_service.dtos.RegisterUserDto;
import com.athem.cms.service.cms_service.model.User;
import com.athem.cms.service.cms_service.repository.UserRepository;
import com.athem.cms.service.cms_service.utils.RestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    protected static final Logger logger = LogManager.getLogger();


    public User signUp(RegisterUserDto input) {
        User user = new User();
        user.setFullName(input.getFullName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        logger.info("user :{} ", RestUtil.toJson(user));
        return userRepository.save(user);
    }

    public User authenticate (LoginUserDto input) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(),input.getPassword()));
        return userRepository.findByEmail(input.getEmail()).orElseThrow();
    }
}
