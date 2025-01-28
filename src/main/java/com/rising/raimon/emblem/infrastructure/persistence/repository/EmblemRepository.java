package com.rising.raimon.emblem.infrastructure.persistence.repository;

import com.rising.raimon.emblem.infrastructure.persistence.entities.EmblemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmblemRepository extends JpaRepository<EmblemEntity, Integer> {

}
