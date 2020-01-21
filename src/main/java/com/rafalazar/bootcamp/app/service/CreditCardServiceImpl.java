package com.rafalazar.bootcamp.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafalazar.bootcamp.app.client.PersonalClient;
import com.rafalazar.bootcamp.app.document.CreditCard;
import com.rafalazar.bootcamp.app.dto.PersonalDto;
import com.rafalazar.bootcamp.app.repository.CreditCardRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditCardServiceImpl implements CreditCardService{

	@Autowired
	private PersonalClient client;
	
	@Autowired
	private CreditCardRepository repo;
	
	@Override
	public Flux<CreditCard> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<CreditCard> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public Mono<CreditCard> update(CreditCard card) {
		return repo.findById(card.getId())
				.map(c -> card)
				.flatMap(repo::save);
	}

	@Override
	public Mono<Void> delete(CreditCard card) {
		return repo.delete(card);
	}

	@Override
	public Mono<CreditCard> save(CreditCard card) {
		return repo.save(card);
	}

	@Override
	public Mono<PersonalDto> createById(String id) {
		return client.createById(id);
	}

	@Override
	public Flux<PersonalDto> findAllClients() {
		return client.findAllClients();
	}

}
