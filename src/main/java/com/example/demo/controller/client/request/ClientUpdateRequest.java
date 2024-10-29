package com.example.demo.controller.client.request;

import java.time.LocalDate;

public record ClientUpdateRequest(
        String realname,
        LocalDate birthday,
        String dni,
        String country,
        String gender,
        String Direction,
        String phone
) {
}
