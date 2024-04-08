package com.example.splitwise.services.settleup;

import com.example.splitwise.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private User from;
    private User to;
    private double amount;
}
