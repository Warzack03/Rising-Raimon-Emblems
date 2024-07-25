package com.rising.raimon.stock.domain.service;

import com.rising.raimon.stock.domain.model.enums.ProductTypeEnum;
import com.rising.raimon.stock.domain.model.exception.RisingRaimonException;
import com.rising.raimon.stock.domain.usecases.PricesUseCase;
import com.rising.raimon.stock.infrastructure.persistence.entities.ProductEntity;
import com.rising.raimon.stock.infrastructure.persistence.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PricesService implements PricesUseCase {

    private final ProductEntityRepository productEntityRepository;

    @Override
    public void addSellPrice(ProductTypeEnum productType, Double price) throws RisingRaimonException {
        try {
            ProductEntity response = productEntityRepository.findByType(productType.getValue());
            response.setSellPrice(price);
            productEntityRepository.save(response);
        } catch (Exception e) {
            log.error("Error while adding sell price into {} product: {}", productType, e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public void addCostPrice(ProductTypeEnum productType, Double price) throws RisingRaimonException {
        try {
            ProductEntity response = productEntityRepository.findByType(productType.getValue());
            response.setCostPrice(price);
            productEntityRepository.save(response);
        } catch (Exception e) {
            log.error("Error while adding sell price into {} product: {}", productType, e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }
}
