package org.example.auth;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final AuthService authService;

    public AuthController(AuthService authService,
                          UserDetailsServiceImpl userDetailsServiceImpl) {
        this.authService = authService;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @GetMapping("/me")
    public Long getCurrentUserId(Authentication authentication) {

        String email = authentication.getName();

        return userDetailsServiceImpl.getUserIdByEmail(email);
    }
}