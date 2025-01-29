package com.rising.raimon.emblem.infrastructure.persistence.repository;

import com.rising.raimon.emblem.infrastructure.persistence.entities.NewsletterSubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface NewsletterSubscriptionRepository extends JpaRepository<NewsletterSubscriptionEntity, Integer> {

    Optional<NewsletterSubscriptionEntity> findByUserId(int userId);
    List<NewsletterSubscriptionEntity> findByExpirationDateBefore(LocalDate now);
    List<NewsletterSubscriptionEntity> findByExpirationDateAfter(LocalDate now);
}
