package com.hbdemos.switchlibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String name;
    private String password;
}
