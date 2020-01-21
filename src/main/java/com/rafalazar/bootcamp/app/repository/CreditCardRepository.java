package com.rafalazar.bootcamp.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.rafalazar.bootcamp.app.document.CreditCard;

public interface CreditCardRepository extends ReactiveMongoRepository<CreditCard, String>{
	
}
