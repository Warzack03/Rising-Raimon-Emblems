package com.rising.raimon.emblem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmblemDTO {

    private int id;
    private String name;
    private int level;

}
