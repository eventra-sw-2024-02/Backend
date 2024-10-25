package com.example.demo.controller.user.request;

public record LoginRequest (
        String email,
        String password
)
{ }
