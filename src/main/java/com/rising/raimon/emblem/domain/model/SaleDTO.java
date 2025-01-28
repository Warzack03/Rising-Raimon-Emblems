package com.rising.raimon.emblem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SaleDTO {

    private int id;
    private LocalDateTime date;
    private float value;
    private UserDTO user;
    private EmblemDTO emblem;

}
