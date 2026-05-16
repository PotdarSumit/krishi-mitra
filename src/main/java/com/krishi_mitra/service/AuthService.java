package com.krishi_mitra.service;

import com.krishi_mitra.dto.request.LoginRequest;
import com.krishi_mitra.dto.request.RegisterRequest;
import com.krishi_mitra.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest registerRequest);
    AuthResponse login (LoginRequest loginRequest);
}
