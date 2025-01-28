//package com.rising.raimon.emblem.domain.service;
//
//import com.rising.raimon.emblem.domain.model.enums.ProductTypeEnum;
//import com.rising.raimon.emblem.domain.model.exception.RisingRaimonException;
//import com.rising.raimon.emblem.domain.usecases.PricesUseCase;
//import com.rising.raimon.emblem.infrastructure.persistence.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class PricesService implements PricesUseCase {
//
//    private final UserRepository userRepository;
//
//    @Override
//    public void addSellPrice(ProductTypeEnum productType, Double price) throws RisingRaimonException {
//        try {
//            com.rising.raimon.emblem.infrastructure.persistence.entities.UserEntity response = userRepository.findByType(productType.getValue());
//            response.setSellPrice(price);
//            userRepository.save(response);
//        } catch (Exception e) {
//            log.error("Error while adding sell price into {} product: {}", productType, e.getMessage());
//            throw new RisingRaimonException(e.getMessage());
//        }
//    }
//
//    @Override
//    public void addCostPrice(ProductTypeEnum productType, Double price) throws RisingRaimonException {
//        try {
//            com.rising.raimon.emblem.infrastructure.persistence.entities.UserEntity response = userRepository.findByType(productType.getValue());
//            response.setCostPrice(price);
//            userRepository.save(response);
//        } catch (Exception e) {
//            log.error("Error while adding sell price into {} product: {}", productType, e.getMessage());
//            throw new RisingRaimonException(e.getMessage());
//        }
//    }
//}
