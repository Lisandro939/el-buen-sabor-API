package com.apiREST.API.Auth;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @GetMapping(value = "login")
    public String login()
    {
        return "Login from public endpoint";
    }

    @GetMapping(value = "register")
    public String register()
    {
        return "Register from public endpoint";
    }
}