package com.rising.raimon.emblem.infrastructure.persistence.repository;

import com.rising.raimon.emblem.infrastructure.persistence.entities.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleEntityRepository extends JpaRepository<SaleEntity, Integer> {

}
