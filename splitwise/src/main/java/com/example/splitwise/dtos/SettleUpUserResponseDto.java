package com.example.splitwise.dtos;

import com.example.splitwise.services.settleup.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDto {
    private List<Transaction> transactions;
}