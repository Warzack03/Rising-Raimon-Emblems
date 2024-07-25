package com.rising.raimon.stock.domain.usecases;

import com.rising.raimon.stock.domain.model.enums.ProductTypeEnum;
import com.rising.raimon.stock.domain.model.exception.RisingRaimonException;

public interface PricesUseCase {
    void addSellPrice(ProductTypeEnum productType, Double price) throws RisingRaimonException;

    void addCostPrice(ProductTypeEnum productType, Double price) throws RisingRaimonException;
}
