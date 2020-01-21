package com.rafalazar.bootcamp.app.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Document("creditCard")
public class CreditCard {
	
	@Id
	private String id;
	private String numCard;
	private String nameOwner;
	private String lastNameOwner;
	private String dniOwner;
	private String securityCode;
	private Double balance;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updateDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date expirationDate;
	
	public CreditCard() {
		
	}
	
	public CreditCard(String numCard,String nameOwner,String lastNameOwner,String dniOwner,String securityCode,Double balance) {
		this.numCard = numCard;
		this.nameOwner = nameOwner;
		this.lastNameOwner = lastNameOwner;
		this.dniOwner = dniOwner;
		this.securityCode = securityCode;
		this.balance = balance;
	}

}
