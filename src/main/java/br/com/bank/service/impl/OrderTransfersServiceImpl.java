package br.com.bank.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.bank.model.OrderTransfers;
import br.com.bank.service.OrderTransfersService;

@Service
public class OrderTransfersServiceImpl implements OrderTransfersService {
    

    public void executeTransfer(OrderTransfers orderTransfers) {
        Integer sourceAccount = orderTransfers.getSourceAccount();
        Integer destionationAccount  = orderTransfers.getDestinationAccount();
        
    }
}
