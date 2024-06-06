package com.sahafbanking.main.model.entity;

import java.math.BigDecimal;

import com.sahafbanking.main.model.AccountStatus;
import com.sahafbanking.main.model.AccountType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SAHAF_ACCOUNTS")
public class BankAccountEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	private String number;
	
	@Enumerated(EnumType.STRING)
	private AccountType type;
	
	@Enumerated(EnumType.STRING)
	private AccountStatus status;
	
	private BigDecimal availableBalance;
	
	private BigDecimal actualBalance;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
