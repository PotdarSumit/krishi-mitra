package com.krishi_mitra.service;

import com.krishi_mitra.dto.request.LoginRequest;
import com.krishi_mitra.dto.request.RegisterRequest;
import com.krishi_mitra.dto.response.AuthResponse;
import com.krishi_mitra.entity.User;
import com.krishi_mitra.repository.UserRepository;
import com.krishi_mitra.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.getEmail())){
            throw new RuntimeException("Email already exists.");
        }

        User user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .phone(registerRequest.getPhone())
                .address(registerRequest.getAddress())
                .role(registerRequest.getRole())
                .build();

        userRepository.save(user);
        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(token, "Registration Successful");
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new RuntimeException("User not found."));
        if(!passwordEncoder.matches(loginRequest.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid credentials..");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(token, "Login Successful.");
    }



}
