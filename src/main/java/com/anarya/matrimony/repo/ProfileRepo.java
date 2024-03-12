package com.anarya.matrimony.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anarya.matrimony.domain.ProfileEntity;

public interface ProfileRepo extends JpaRepository<ProfileEntity, Integer> {

}
