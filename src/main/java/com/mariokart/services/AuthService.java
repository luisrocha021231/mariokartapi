package com.mariokart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mariokart.dto.NewUserDTO;
import com.mariokart.entities.Role;
import com.mariokart.entities.User;
import com.mariokart.enums.RoleList;
import com.mariokart.jwt.JwtUtil;
import com.mariokart.repositories.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    // private AuthenticationManagerBuilder authenticationManagerBuilder;

    public String authenticate(String username, String password) {
        // UsernamePasswordAuthenticationToken authenticationToken = new
        // UsernamePasswordAuthenticationToken(username, password);
        // Authentication authResult =
        // authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        // SecurityContextHolder.getContext().setAuthentication(authResult);
        // return jwtUtil.generateToken(authResult);
        Authentication authResult = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authResult);
        return jwtUtil.generateToken(authResult);
    }

    public void registerUser(NewUserDTO newUserDTO) {
        if (userService.existsByUsername(newUserDTO.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        Role roleUser = roleRepository.findByName(RoleList.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        User user = new User(newUserDTO.getUsername(), passwordEncoder.encode(newUserDTO.getPassword()), roleUser);
        userService.save(user);

    }
}
