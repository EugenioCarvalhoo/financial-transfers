package br.com.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.bank.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    @Query("select us from br.com.bank.model.User us where us.account.accountNumber = :accountNumber")
    Optional<User> findByAccountNumber(@Param("accountNumber") String accountNumber);
    
}
