package com.example.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettleUpGroupRequestDto {
    private Long userId;
    private Long groupId;
}
