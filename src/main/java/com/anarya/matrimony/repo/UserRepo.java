package com.anarya.matrimony.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anarya.matrimony.domain.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

	public UserEntity findByEmail(String email);

	public UserEntity findByEmailAndPwd(String email, String pwd);
}
