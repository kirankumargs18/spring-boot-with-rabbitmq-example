package com.globallogic.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.entity.UserLogin;

@Repository
public interface LoginRepository extends MongoRepository<UserLogin, String>{

}
