package com.example.demo.controller.client.response;

import java.time.LocalDate;

public record ClientResponse (
        Long id,
        String username,
        String email,
        String realname,
        LocalDate birthdate,
        String dni,
        String country,
        String gender,
        String Direction,
        String phone
) { }
