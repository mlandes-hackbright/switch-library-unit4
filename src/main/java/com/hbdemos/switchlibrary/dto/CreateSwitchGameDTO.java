package com.hbdemos.switchlibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateSwitchGameDTO {
    private String title;
    private String rating;
    private String publisher;
}
