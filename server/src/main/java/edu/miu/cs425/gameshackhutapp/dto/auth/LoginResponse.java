package edu.miu.cs425.gameshackhutapp.dto.auth;

import edu.miu.cs425.gameshackhutapp.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String accessToken;
    private String refreshToken;

    private String userName;
    private String role;
}