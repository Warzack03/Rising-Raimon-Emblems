package com.rising.raimon.emblem.domain.usecases;

import com.rising.raimon.emblem.application.model.request.SaleRequestDTO;
import com.rising.raimon.emblem.domain.model.SaleDTO;
import com.rising.raimon.emblem.domain.model.exception.RisingRaimonException;

import java.util.List;

public interface SaleUseCase {
    SaleDTO createSale(SaleRequestDTO request) throws RisingRaimonException;
    void deleteSale(int saleId) throws RisingRaimonException;
    SaleDTO getSaleById(int saleId) throws RisingRaimonException;
    List<SaleDTO> getSales() throws RisingRaimonException;
}
