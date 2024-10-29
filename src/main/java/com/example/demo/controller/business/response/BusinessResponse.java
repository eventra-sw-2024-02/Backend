package com.example.demo.controller.business.response;

public record BusinessResponse(
        Long id,
        String username,
        String email,
        String businessName,
        String ruc,
        String address,
        String reasonSocial,
        String comercialName,
        String category
) { }
