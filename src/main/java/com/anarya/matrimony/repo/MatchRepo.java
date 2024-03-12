package com.anarya.matrimony.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anarya.matrimony.domain.MatchEntity;

public interface MatchRepo extends JpaRepository<MatchEntity, Long> {

}
