package edu.miu.cs.cs425.eregistrarwebapi.service;

import edu.miu.cs425.gameshackhutapp.dto.auth.LoginRequest;
import edu.miu.cs425.gameshackhutapp.dto.auth.LoginResponse;
import edu.miu.cs425.gameshackhutapp.dto.auth.RefreshToken;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshToken refreshTokenRequest);
}
