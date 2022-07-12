package edu.miu.cs.cs425.eregistrarwebapi.service;

import edu.miu.cs.cs425.eregistrarwebapi.dto.LoginRequest;
import edu.miu.cs.cs425.eregistrarwebapi.dto.LoginResponse;
import edu.miu.cs.cs425.eregistrarwebapi.dto.RefreshToken;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshToken refreshTokenRequest);
}
