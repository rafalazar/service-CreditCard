package com.rafalazar.bootcamp.app.service;
import com.rafalazar.bootcamp.app.document.CreditCard;
import com.rafalazar.bootcamp.app.dto.PersonalDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardService {
	
	public Flux<CreditCard> findAll();
	public Mono<CreditCard> findById(String id);
	public Mono<CreditCard> update(CreditCard card);
	public Mono<Void> delete(CreditCard card);
	public Mono<CreditCard> save(CreditCard card);
	
	public Mono<PersonalDto> createById(String id);
	public Flux<PersonalDto> findAllClients();

}
