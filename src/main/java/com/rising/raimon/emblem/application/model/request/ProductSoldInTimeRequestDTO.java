package com.rising.raimon.emblem.application.model.request;

import com.rising.raimon.emblem.domain.model.enums.EmblemEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductSoldInTimeRequestDTO {

    private EmblemEnum productType;
    private LocalDate startDate;
    private LocalDate endDate;

}
