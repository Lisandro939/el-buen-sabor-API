package com.apiREST.API.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
    public class AuthController {

        private final AuthService authService;

        @PostMapping(value = "/login") //no puedo mandar un body con get
        public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
        {
            return ResponseEntity.ok(authService.login(request));
        }

        @PostMapping(value = "register")
        public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
        {
            return ResponseEntity.ok(authService.register(request));
        }
    }

