package com.rising.raimon.emblem.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rising.raimon.emblem.application.model.request.SaleRequestDTO;
import com.rising.raimon.emblem.domain.model.SaleDTO;
import com.rising.raimon.emblem.domain.model.exception.RisingRaimonException;
import com.rising.raimon.emblem.domain.usecases.SaleUseCase;
import com.rising.raimon.emblem.infrastructure.persistence.entities.EmblemEntity;
import com.rising.raimon.emblem.infrastructure.persistence.entities.SaleEntity;
import com.rising.raimon.emblem.infrastructure.persistence.entities.UserEntity;
import com.rising.raimon.emblem.infrastructure.persistence.repository.EmblemRepository;
import com.rising.raimon.emblem.infrastructure.persistence.repository.SaleRepository;
import com.rising.raimon.emblem.infrastructure.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SaleService implements SaleUseCase {

    private final SaleRepository saleRepository;
    private final EmblemRepository emblemRepository;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    private static final String NO_SALE_FOUND_ERROR = "No sale found";
    private static final String NO_EMBLEM_FOUND_ERROR = "No emblem found";
    private static final String NO_USER_FOUND_ERROR = "No user found";

    @Override
    public SaleDTO createSale(SaleRequestDTO request) throws RisingRaimonException {
        try {
            Optional<EmblemEntity> emblem = emblemRepository.findByName(request.getEmblem().getName());
            if (emblem.isEmpty()) {
                log.error(NO_EMBLEM_FOUND_ERROR);
                throw new RisingRaimonException(NO_EMBLEM_FOUND_ERROR);
            }

            Optional<UserEntity> user = userRepository.findById(request.getUserId());
            if (user.isEmpty()) {
                log.error(NO_USER_FOUND_ERROR);
                throw new RisingRaimonException(NO_USER_FOUND_ERROR);
            }

            SaleEntity entityToSave = SaleEntity.builder()
                    .id(request.getId())
                    .value(request.getValue())
                    .date(request.getDate() == null ? LocalDateTime.now() : request.getDate())
                    .emblem(emblem.get())
                    .user(user.get())
                    .build();

            return objectMapper.convertValue(saleRepository.save(entityToSave), SaleDTO.class);
        } catch (Exception e) {
            log.error("Error while saving sale -> {}", e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public void deleteSale(int saleId) throws RisingRaimonException {
        try {
            saleRepository.deleteById(saleId);
        } catch (Exception e) {
            log.error("Error while deleting sale -> {}", e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public SaleDTO getSaleById(int saleId) throws RisingRaimonException {
        try {
            Optional<SaleEntity> optionalSale = saleRepository.findById(saleId);
            if (optionalSale.isEmpty()) {
                throw new RisingRaimonException(NO_SALE_FOUND_ERROR);
            }
            return objectMapper.convertValue(optionalSale.get(), SaleDTO.class);
        } catch (Exception e) {
            log.error("Error while getting sale -> {}", e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public List<SaleDTO> getSales() throws RisingRaimonException {
        try {
            List<SaleEntity> emblems = saleRepository.findAll();
            if (emblems.isEmpty()) {
                throw new RisingRaimonException(NO_SALE_FOUND_ERROR);
            }
            return emblems.stream().map(saleEntity -> objectMapper.convertValue(saleEntity, SaleDTO.class)).toList();
        } catch (Exception e) {
            log.error("Error while getting sales -> {}", e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }
}
