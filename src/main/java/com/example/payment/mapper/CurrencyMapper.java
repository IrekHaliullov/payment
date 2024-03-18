package com.example.payment.mapper;


import com.example.payment.domain.Currency;
import com.example.payment.dto.CurrencyRequest;
import com.example.payment.dto.CurrencyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrencyMapper {

    public CurrencyResponse toDto(Currency currency) {
        CurrencyResponse response = new CurrencyResponse();
        response.setId(currency.getId());
        response.setName(currency.getName());
        return response;
    }

    public Currency toEntity(CurrencyRequest request) {
        Currency response = new Currency();
        response.setName(request.getName());
        return response;
    }
}
