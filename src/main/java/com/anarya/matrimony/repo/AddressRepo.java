package com.anarya.matrimony.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anarya.matrimony.domain.AddressEntity;

public interface AddressRepo  extends JpaRepository<AddressEntity, Integer>{

}
