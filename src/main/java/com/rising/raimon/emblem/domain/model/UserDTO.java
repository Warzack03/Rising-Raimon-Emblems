package com.rising.raimon.emblem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

    private int id;
    private String fullName;
    private String username;
    private String email;
    private String phone;

}
