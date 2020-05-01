package com.dangducton.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dangducton.model.UserInfo;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, Long>{

	UserInfo findByEmailAndEnabled(String email, boolean enabled);

	UserInfo findByEmail(String email);

}
