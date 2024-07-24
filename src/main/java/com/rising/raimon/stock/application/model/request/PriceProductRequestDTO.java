package com.rising.raimon.stock.application.model.request;

import com.rising.raimon.stock.domain.model.enums.ProductTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PriceProductRequestDTO {

    private ProductTypeEnum productType;
    private Double price;

}
