package com.test.usermicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class UserDTO {

    private String name;
    private String username;
    private int age;
    private String gender;
    private String address;
    private String info;
}
