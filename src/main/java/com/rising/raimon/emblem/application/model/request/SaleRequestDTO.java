package com.rising.raimon.emblem.application.model.request;

import com.rising.raimon.emblem.domain.model.enums.EmblemEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SaleRequestDTO {

    private int id;
    private LocalDateTime date;
    private float value;
    private EmblemEnum emblem;
    private int userId;

}
