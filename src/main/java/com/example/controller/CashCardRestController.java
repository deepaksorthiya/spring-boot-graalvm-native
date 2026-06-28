package com.example.controller;

import com.example.dto.CashCard;
import com.example.dto.CashCardDto;
import com.example.dto.UserDto;
import com.example.repository.CashCardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cashcards")
public class CashCardRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CashCardRestController.class);

    private CashCardRepository cashCardRepository;

    public CashCardRestController(CashCardRepository cashCardRepository) {
        this.cashCardRepository = cashCardRepository;
    }

    @GetMapping("/entities")
    public Iterable<CashCard> listCashCards() {
        LOGGER.info("Fetching all cash cards");
        return cashCardRepository.findAll();
    }

    @GetMapping("/dtos")
    public List<CashCardDto> listCashCardsDto() {
        LOGGER.info("Fetching all cash cards as DTOs");
        return cashCardRepository.findAll().stream()
                .map(c -> new CashCardDto(c.id(), c.amount(), new UserDto(c.owner()))).toList();
    }

}
