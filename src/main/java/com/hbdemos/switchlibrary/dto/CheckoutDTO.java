package com.hbdemos.switchlibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CheckoutDTO {
    private Long id;
    private Long userId;
    private Long gameId;
}
