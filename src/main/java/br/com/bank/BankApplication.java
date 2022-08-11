package br.com.bank;

import java.math.BigDecimal;
import java.util.Arrays;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.bank.model.Account;
import br.com.bank.model.User;
import br.com.bank.repository.UserRepository;
import br.com.bank.service.UserService;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepo) { 
		return run -> {
			Account account1 = Account.builder()
			.accountNumber("123123")
			.amount(new BigDecimal("1555"))
			.build();

			User user1 = User.builder()
			.fristName("Henry")
			.lastName("Cavill")
			.account(account1)
			.build();

			User user2 = User.builder()
			.fristName("Anya")
			.lastName("Chalotra")
			.account(Account.builder()
			.accountNumber("001223")
			.amount(new BigDecimal("2255"))
			.build())
			.build();
			
			User user3 = User.builder()
			.fristName("Joey")
			.lastName("Batey")
			.account(Account.builder()
			.accountNumber("010126")
			.amount(new BigDecimal("3055"))
			.build())
			.build();
			
			userRepo.saveAll(Arrays.asList(user1, user2 ,user3));
		};
	}

}
