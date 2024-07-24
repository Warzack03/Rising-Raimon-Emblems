package com.rising.raimon.stock.domain.usecases;

import com.rising.raimon.stock.application.model.request.ProductSoldInTimeRequestDTO;
import com.rising.raimon.stock.domain.model.enums.ProductTypeEnum;
import com.rising.raimon.stock.domain.model.exception.RisingRaimonException;

public interface ProductUseCase {
    void buyProduct(ProductTypeEnum productType, int amount) throws RisingRaimonException;
    void sellProduct(ProductTypeEnum productType, int amount) throws RisingRaimonException;
    Double totalSpentByProductType(ProductTypeEnum productType) throws RisingRaimonException;
    Double totalEarnedByProductType(ProductTypeEnum productType) throws RisingRaimonException;
    Double profitByProductType(ProductTypeEnum productType) throws RisingRaimonException;
    Integer productsSoldByProductType(ProductTypeEnum productType) throws RisingRaimonException;
    Integer productsSoldBetweenDates(ProductSoldInTimeRequestDTO request) throws RisingRaimonException;
}
