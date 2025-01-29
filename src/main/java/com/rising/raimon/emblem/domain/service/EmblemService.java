package com.rising.raimon.emblem.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rising.raimon.emblem.domain.model.EmblemDTO;
import com.rising.raimon.emblem.domain.model.enums.EmblemEnum;
import com.rising.raimon.emblem.domain.model.exception.RisingRaimonException;
import com.rising.raimon.emblem.domain.usecases.EmblemUseCase;
import com.rising.raimon.emblem.infrastructure.persistence.entities.EmblemEntity;
import com.rising.raimon.emblem.infrastructure.persistence.repository.EmblemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmblemService implements EmblemUseCase {

    private final EmblemRepository emblemRepository;
    private final ObjectMapper objectMapper;

    private static final String NO_EMBLEM_FOUND_ERROR = "No emblem found";

    @Override
    public EmblemDTO createEmblem(EmblemEnum request, int emblemId) throws RisingRaimonException {
        try {
            EmblemEntity entityToSave = EmblemEntity.builder()
                    .id(emblemId)
                    .name(request.getName())
                    .level(request.getLevel())
                    .build();
            return objectMapper.convertValue(emblemRepository.save(entityToSave), EmblemDTO.class);
        } catch (Exception e) {
            log.error("Error while saving emblem -> {}", e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public void deleteEmblem(int emblemId) throws RisingRaimonException {
        try {
            emblemRepository.deleteById(emblemId);
        } catch (Exception e) {
            log.error("Error while deleting emblem -> {}", e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public EmblemDTO getEmblemById(int emblemId) throws RisingRaimonException {
        try {
            Optional<EmblemEntity> optionalEmblem = emblemRepository.findById(emblemId);
            if (optionalEmblem.isEmpty()) {
                throw new RisingRaimonException(NO_EMBLEM_FOUND_ERROR);
            }
            return objectMapper.convertValue(optionalEmblem.get(), EmblemDTO.class);
        } catch (Exception e) {
            log.error("Error while getting emblem -> {}", e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public List<EmblemDTO> getEmblems() throws RisingRaimonException {
        try {
            List<EmblemEntity> emblems = emblemRepository.findAll();
            if (emblems.isEmpty()) {
                throw new RisingRaimonException(NO_EMBLEM_FOUND_ERROR);
            }
            return emblems.stream().map(emblemEntity -> objectMapper.convertValue(emblemEntity, EmblemDTO.class)).toList();
        } catch (Exception e) {
            log.error("Error while getting emblems -> {}", e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }
}
