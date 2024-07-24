package com.rising.raimon.stock.domain.usecases;

import com.rising.raimon.stock.application.model.request.PriceProductRequestDTO;
import com.rising.raimon.stock.domain.model.exception.RisingRaimonException;

public interface PricesUseCase {
    void addSellPrice(PriceProductRequestDTO request) throws RisingRaimonException;

    void addCostPrice(PriceProductRequestDTO request) throws RisingRaimonException;
}
