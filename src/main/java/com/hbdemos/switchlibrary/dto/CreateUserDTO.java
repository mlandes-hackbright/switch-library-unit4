package com.hbdemos.switchlibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateUserDTO {
    private String name;
    private String password;
}
