package br.com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bank.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    
}
