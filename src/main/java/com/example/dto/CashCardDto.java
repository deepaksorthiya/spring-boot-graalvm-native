package com.example.dto;

public record CashCardDto(Long id, Double amount, UserDto owner) {
    @Override
    public String toString() {
        return owner.id();
    }
}

