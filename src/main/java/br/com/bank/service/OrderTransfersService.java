package br.com.bank.service;

import br.com.bank.dto.OrderTransfersDTO;
import java.util.List;
public interface OrderTransfersService {
    
    OrderTransfersDTO executeTransfer(OrderTransfersDTO orderTransfers);

    List<OrderTransfersDTO> getAllOrderTransfers();
}
