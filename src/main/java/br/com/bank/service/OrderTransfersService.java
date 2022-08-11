package br.com.bank.service;

import br.com.bank.dto.OrderTransfersDTO;

public interface OrderTransfersService {
    
    OrderTransfersDTO executeTransfer(OrderTransfersDTO orderTransfers);
}
