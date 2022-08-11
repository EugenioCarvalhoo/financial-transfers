package br.com.bank.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import br.com.bank.dto.OrderTransfersDTO;
import br.com.bank.service.OrderTransfersService;

@RestController
@RequestMapping("/v1/order_transfer")
@CrossOrigin
public class OrderTransfersController {

    @Autowired
    OrderTransfersService orderTransfersService;

    @PostMapping
    public ResponseEntity<OrderTransfersDTO> executeTransfer(
        @RequestBody OrderTransfersDTO orderTransfers) {
            OrderTransfersDTO response = orderTransfersService.executeTransfer(orderTransfers);
        if (orderTransfers.getId() == null) {
            return new ResponseEntity<>(orderTransfers, HttpStatus.CREATED);
        }
        return ResponseEntity.ok().body(orderTransfers);
    }

    @GetMapping
    public ResponseEntity<List<OrderTransfersDTO>> getAllOrderTransfers() {
        return ResponseEntity.ok().body(orderTransfersService.getAllOrderTransfers());
    }
     
}
