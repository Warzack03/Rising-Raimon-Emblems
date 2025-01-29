package com.rising.raimon.emblem.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rising.raimon.emblem.application.model.request.NewsletterSubscriptionRequestDTO;
import com.rising.raimon.emblem.domain.model.NewsletterSubscriptionDTO;
import com.rising.raimon.emblem.domain.model.exception.RisingRaimonException;
import com.rising.raimon.emblem.domain.usecases.NewsletterSubscriptionUseCase;
import com.rising.raimon.emblem.infrastructure.persistence.entities.NewsletterSubscriptionEntity;
import com.rising.raimon.emblem.infrastructure.persistence.entities.UserEntity;
import com.rising.raimon.emblem.infrastructure.persistence.repository.NewsletterSubscriptionRepository;
import com.rising.raimon.emblem.infrastructure.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsletterSubscriptionService implements NewsletterSubscriptionUseCase {

    private final NewsletterSubscriptionRepository newsletterSubscriptionRepository;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    private static final String NO_NEWS_LETTER_FOUND_ERROR = "No newsletter found";
    private static final String NO_USER_FOUND_ERROR = "No user found";

    @Override
    public NewsletterSubscriptionDTO createNewsletterSubscription(NewsletterSubscriptionRequestDTO request) throws RisingRaimonException {
        try {
            Optional<UserEntity> user = userRepository.findById(request.getUserId());
            if (user.isEmpty()) {
                log.error(NO_USER_FOUND_ERROR);
                throw new RisingRaimonException(NO_USER_FOUND_ERROR);
            }

            NewsletterSubscriptionEntity entity = NewsletterSubscriptionEntity.builder()
                    .id(0)
                    .cost(request.getCosts())
                    .startDate(LocalDate.now())
                    .expirationDate(LocalDate.now().plusMonths(request.getMonths()))
                    .user(user.get())
                    .build();
            return objectMapper.convertValue(newsletterSubscriptionRepository.save(entity), NewsletterSubscriptionDTO.class);
        } catch (Exception e) {
            log.error("Error while saving newsletter subscription -> {}", e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public NewsletterSubscriptionDTO addMonthsIntoNewsletterSubscription(int userId, int moths) throws RisingRaimonException {
        try {
            Optional<NewsletterSubscriptionEntity> newsletterSubscriptionEntity = newsletterSubscriptionRepository.findByUserId(userId);
            if (newsletterSubscriptionEntity.isEmpty()) {
                log.error(NO_NEWS_LETTER_FOUND_ERROR);
                throw new RisingRaimonException(NO_NEWS_LETTER_FOUND_ERROR);
            }

            NewsletterSubscriptionEntity entity = newsletterSubscriptionEntity.get();
            entity.setExpirationDate(entity.getExpirationDate().plusMonths(moths));
            return objectMapper.convertValue(newsletterSubscriptionRepository.save(entity), NewsletterSubscriptionDTO.class);
        } catch (Exception e) {
            log.error("Error while adding months into newsletter subscription -> {}", e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public NewsletterSubscriptionDTO getNewsletterSubscriptionById(int newsletterSubscriptionId) throws RisingRaimonException {
        try {
            Optional<NewsletterSubscriptionEntity> newsletterSubscriptionEntity = newsletterSubscriptionRepository.findById(newsletterSubscriptionId);
            if (newsletterSubscriptionEntity.isEmpty()) {
                throw new RisingRaimonException(NO_NEWS_LETTER_FOUND_ERROR);
            }
            return objectMapper.convertValue(newsletterSubscriptionEntity.get(), NewsletterSubscriptionDTO.class);
        } catch (Exception e) {
            log.error("Error while getting newsletter subscription -> {}", e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public NewsletterSubscriptionDTO getNewsletterSubscriptionByUserId(int userId) throws RisingRaimonException {
        try {
            Optional<NewsletterSubscriptionEntity> newsletterSubscriptionEntity = newsletterSubscriptionRepository.findByUserId(userId);
            if (newsletterSubscriptionEntity.isEmpty()) {
                log.error(NO_NEWS_LETTER_FOUND_ERROR);
                throw new RisingRaimonException(NO_NEWS_LETTER_FOUND_ERROR);
            }
            return objectMapper.convertValue(newsletterSubscriptionEntity.get(), NewsletterSubscriptionDTO.class);
        } catch (Exception e) {
            log.error("Error while getting newsletter subscription -> {}", e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public List<NewsletterSubscriptionDTO> getInactiveNewsletterSubscriptions() throws RisingRaimonException {
        try {
            List<NewsletterSubscriptionEntity> newsletterSubscriptions = newsletterSubscriptionRepository.findByExpirationDateBefore(LocalDate.now());
            if (newsletterSubscriptions.isEmpty()) {
                log.error(NO_NEWS_LETTER_FOUND_ERROR);
                throw new RisingRaimonException(NO_NEWS_LETTER_FOUND_ERROR);
            }
            return newsletterSubscriptions.stream().map(newsletterSubscription ->
                    objectMapper.convertValue(newsletterSubscription, NewsletterSubscriptionDTO.class)).toList();
        } catch (Exception e) {
            log.error("Error while getting inactive newsletter subscription -> {}", e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public List<NewsletterSubscriptionDTO> getActiveNewsletterSubscriptions() throws RisingRaimonException {
        try {
            List<NewsletterSubscriptionEntity> newsletterSubscriptions = newsletterSubscriptionRepository.findByExpirationDateAfter(LocalDate.now());
            if (newsletterSubscriptions.isEmpty()) {
                log.error(NO_NEWS_LETTER_FOUND_ERROR);
                throw new RisingRaimonException(NO_NEWS_LETTER_FOUND_ERROR);
            }
            return newsletterSubscriptions.stream().map(newsletterSubscription ->
                    objectMapper.convertValue(newsletterSubscription, NewsletterSubscriptionDTO.class)).toList();
        } catch (Exception e) {
            log.error("Error while getting active newsletter subscription -> {}", e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }
}
