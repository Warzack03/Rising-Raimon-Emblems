package com.rising.raimon.stock.infrastructure.persistence.repository;

import com.rising.raimon.stock.infrastructure.persistence.entities.SellEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SellEntityRepository extends JpaRepository<SellEntity, Long> {

    @Query(
            value = "SELECT COUNT(*) FROM sell_dates WHERE type = :productType AND date >= :startDate AND date <= :endDate",
            nativeQuery = true
    )
    Long findByDates(String productType, String startDate, String endDate);
}
