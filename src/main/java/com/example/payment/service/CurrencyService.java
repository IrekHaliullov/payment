package com.example.payment.service;

import com.example.payment.dto.CurrencyRequest;
import com.example.payment.dto.CurrencyResponse;
import com.example.payment.mapper.CurrencyMapper;
import com.example.payment.repository.CurrencyRepository;
import com.example.payment.domain.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final CurrencyMapper currencyMapper;

    public List<CurrencyResponse> findAll() {
        return currencyRepository.findAll().stream().map(currencyMapper::toDto).collect(Collectors.toList());
    }

    public CurrencyResponse findById(Long currencyId) {
        Currency currency = currencyRepository.findById(currencyId).get();
        return currencyMapper.toDto(currency);
    }

    public CurrencyResponse create(CurrencyRequest request) {
        Currency currency = currencyMapper.toEntity(request);
        return currencyMapper.toDto(currencyRepository.save(currency));
    }
}
