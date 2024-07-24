package com.rising.raimon.stock.infrastructure.persistence.repository;

import com.rising.raimon.stock.infrastructure.persistence.entities.SellEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellEntityRepository extends JpaRepository<SellEntity, Long> {

}
