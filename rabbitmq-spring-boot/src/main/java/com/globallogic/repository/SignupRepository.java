package com.globallogic.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.entity.UserSignUp;

@Repository
public interface SignupRepository extends MongoRepository<UserSignUp, String> {

}
