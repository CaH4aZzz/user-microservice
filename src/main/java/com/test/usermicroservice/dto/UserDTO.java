package com.test.usermicroservice.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class UserDTO {

    private String name;
    private int age;
    private String gender;
    private String address;
}
