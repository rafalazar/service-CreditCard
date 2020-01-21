package com.rafalazar.bootcamp.app.controllers;

import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafalazar.bootcamp.app.document.CreditCard;
import com.rafalazar.bootcamp.app.dto.PersonalDto;
import com.rafalazar.bootcamp.app.service.CreditCardService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/creditCard")
public class CreditCardController {
	
	@Autowired
	private CreditCardService service;
	
	//SimpleDateFormat
	//
	
	@GetMapping("/findAll")
	Flux<CreditCard> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/findById/{id}")
	Mono<CreditCard> findById(@PathVariable("id") String id){
		return service.findById(id);
	}
	
	@PostMapping("/create")
	public Mono<ResponseEntity<CreditCard>> create(@RequestBody CreditCard card){
		if(card.getCreateDate() == null) {
			card.setCreateDate(new Date());
		}
		
		if(card.getUpdateDate() == null) {
			card.setUpdateDate(new Date());
		}
		
		if(card.getExpirationDate() == null) {
			card.setExpirationDate(new Date());
		}
		
		return service.save(card)
				.map(c -> ResponseEntity.created(URI.create("/creditCard/".concat(c.getId())))
						.contentType(MediaType.APPLICATION_JSON).body(c));
	}
	
	@DeleteMapping("delete/{id}")
	public Mono<ResponseEntity<Void>> delete(@PathVariable String id){
		return service.findById(id).flatMap(c -> {
			return service.delete(c).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
		}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("/update/{id}")
	Mono<CreditCard> update(@PathVariable String id, @RequestBody CreditCard card) {
		return service.update(card);
	}
	
	@PostMapping("/createById/{id}")
	Mono<CreditCard> createById(@PathVariable("id") String id){
		
		return service.createById(id).flatMap(c -> {
			return service.save(
					new CreditCard("453252432",c.getName(),c.getLastName(),c.getDni(),"4535",4000.00)
					);
			
		});
	}
	
	@GetMapping("/findAllClients")
	Flux<PersonalDto> findAllClients(){
		return service.findAllClients();
	}
	
	

}
