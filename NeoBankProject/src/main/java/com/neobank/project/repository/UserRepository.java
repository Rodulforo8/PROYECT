package com.neobank.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.neobank.project.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

	
}
