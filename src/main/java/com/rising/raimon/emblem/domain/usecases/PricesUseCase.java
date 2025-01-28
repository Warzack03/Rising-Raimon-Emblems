package com.rising.raimon.emblem.domain.usecases;

import com.rising.raimon.emblem.domain.model.enums.EmblemEnum;
import com.rising.raimon.emblem.domain.model.exception.RisingRaimonException;

public interface PricesUseCase {
    void addSellPrice(EmblemEnum productType, Double price) throws RisingRaimonException;

    void addCostPrice(EmblemEnum productType, Double price) throws RisingRaimonException;
}
