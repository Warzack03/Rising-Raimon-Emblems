package com.rising.raimon.stock.domain.service;

import com.rising.raimon.stock.application.model.request.ProductSoldInTimeRequestDTO;
import com.rising.raimon.stock.domain.model.enums.ProductTypeEnum;
import com.rising.raimon.stock.domain.model.exception.RisingRaimonException;
import com.rising.raimon.stock.domain.usecases.ProductUseCase;
import com.rising.raimon.stock.infrastructure.persistence.entities.ProductEntity;
import com.rising.raimon.stock.infrastructure.persistence.entities.SellEntity;
import com.rising.raimon.stock.infrastructure.persistence.repository.ProductEntityRepository;
import com.rising.raimon.stock.infrastructure.persistence.repository.SellEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService implements ProductUseCase {

    private final ProductEntityRepository productEntityRepository;
    private final SellEntityRepository sellEntityRepository;

    @Override
    public void buyProduct(ProductTypeEnum productType, int amount) throws RisingRaimonException {
        try {
            ProductEntity response = productEntityRepository.findByType(productType.getValue());
            response.setTotalAmount(response.getTotalAmount() + amount);
            response.setActualStock(response.getActualStock() + amount);
            productEntityRepository.save(response);
        } catch (Exception e) {
            log.error("Error while buying {} -> {}", productType, e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public void sellProduct(ProductTypeEnum productType, int amount) throws RisingRaimonException {
        try {
            ProductEntity response = productEntityRepository.findByType(productType.getValue());
            response.setActualStock(response.getActualStock() - amount);
            productEntityRepository.save(response);

            for (int i = 0; i <amount; i++) {
                SellEntity entity = new SellEntity();
                entity.setDate(LocalDate.now());
                entity.setType(productType.getValue());
                sellEntityRepository.save(entity);
            }
        } catch (Exception e) {
            log.error("Error while selling {} -> {}", productType, e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public Double totalSpentByProductType(ProductTypeEnum productType) throws RisingRaimonException {
        try {
            ProductEntity response = productEntityRepository.findByType(productType.getValue());
            return response.getTotalAmount() * response.getCostPrice();
        } catch (Exception e) {
            log.error("Error while calculating total spent on {} -> {}", productType, e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public Double totalEarnedByProductType(ProductTypeEnum productType) throws RisingRaimonException {
        try {
            ProductEntity response = productEntityRepository.findByType(productType.getValue());
            return (response.getTotalAmount() - response.getActualStock()) * response.getSellPrice();
        } catch (Exception e) {
            log.error("Error while calculating total earned on {} -> {}", productType, e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public Double profitByProductType(ProductTypeEnum productType) throws RisingRaimonException {
        try {
            return totalEarnedByProductType(productType) - totalSpentByProductType(productType);
        } catch (Exception e) {
            log.error("Error while calculating profit on {} -> {}", productType, e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public Integer productsSoldByProductType(ProductTypeEnum productType) throws RisingRaimonException {
        try {
            ProductEntity response = productEntityRepository.findByType(productType.getValue());
            return (response.getTotalAmount() - response.getActualStock());
        } catch (Exception e) {
            log.error("Error while calculating total of product sold of {} -> {}", productType, e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public Integer productsSoldBetweenDates(ProductSoldInTimeRequestDTO request) throws RisingRaimonException {
        try {
            Long count = sellEntityRepository.findByDates(request.getProductType().getValue(),
                    request.getStartDate().toString(), request.getEndDate().toString());
            return count.intValue();
        } catch (Exception e) {
            log.error("Error while calculating products sold between {} and {} -> {}", request.getStartDate(),
                    request.getEndDate(), e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }
}
