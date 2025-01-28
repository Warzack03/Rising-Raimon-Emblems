package com.rising.raimon.emblem.application.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRequestDTO {

    private String fullName;
    private String username;
    private String email;
    private String phone;

}
