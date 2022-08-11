package br.com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bank.model.OrderTransfers;

@Repository
public interface OrderTransferRepository extends JpaRepository<OrderTransfers, Long> {
    
}
