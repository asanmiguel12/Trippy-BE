package auth;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public AuthResponse login(AuthRequest request) {
        // TEMP: replace with real auth + JWT
        String fakeJwt = "fake-jwt-token";
        return new AuthResponse(fakeJwt);
    }
}
