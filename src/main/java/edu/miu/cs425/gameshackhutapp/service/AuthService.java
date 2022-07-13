package edu.miu.cs425.gameshackhutapp.service;

import edu.miu.cs425.gameshackhutapp.dto.auth.LoginRequest;
import edu.miu.cs425.gameshackhutapp.dto.auth.LoginResponse;
import edu.miu.cs425.gameshackhutapp.dto.auth.RefreshToken;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshToken refreshTokenRequest);
}
