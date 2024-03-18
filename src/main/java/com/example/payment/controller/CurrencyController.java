package com.example.payment.controller;

import com.example.payment.dto.CurrencyRequest;
import com.example.payment.dto.CurrencyResponse;
import com.example.payment.service.CurrencyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/currency")
@Tag(name = "01. Справочник валют")
@CrossOrigin
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping
    public List<CurrencyResponse> findAll() {
        return currencyService.findAll();
    }

    @GetMapping("/{currencyId}")
    public CurrencyResponse findById(@PathVariable Long currencyId) {
        return currencyService.findById(currencyId);
    }

    @PostMapping
    public CurrencyResponse create(@Valid @RequestBody CurrencyRequest currencyRequest) {
        return currencyService.create(currencyRequest);
    }
}
