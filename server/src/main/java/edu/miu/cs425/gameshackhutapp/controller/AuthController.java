package edu.miu.cs425.gameshackhutapp.controller;

import edu.miu.cs425.gameshackhutapp.dto.auth.LoginRequest;
import edu.miu.cs425.gameshackhutapp.dto.auth.LoginResponse;
import edu.miu.cs425.gameshackhutapp.dto.auth.RefreshToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.miu.cs.cs425.eregistrarwebapi.service.AuthService;

@RestController
@CrossOrigin
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/auth")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/auth/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshToken refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest);
    }

}