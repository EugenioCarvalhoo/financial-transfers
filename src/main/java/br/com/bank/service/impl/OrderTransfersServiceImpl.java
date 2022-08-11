package br.com.bank.service.impl;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bank.domain.BaseTransfer;
import br.com.bank.domain.TransferA;
import br.com.bank.domain.TransferB;
import br.com.bank.domain.TransferC;
import br.com.bank.domain.TransferD;
import br.com.bank.dto.OrderTransfersDTO;
import br.com.bank.model.Account;
import br.com.bank.model.OrderTransfers;
import br.com.bank.repository.AccountRepository;
import br.com.bank.repository.OrderTransferRepository;
import br.com.bank.repository.UserRepository;
import br.com.bank.service.OrderTransfersService;
import br.com.bank.utils.DateUtil;

import static br.com.bank.utils.DateUtil.parseString;

@Service
public class OrderTransfersServiceImpl implements OrderTransfersService {

    @Autowired
    AccountRepository accountRepo;

    @Autowired
    OrderTransferRepository orderRepo;

    public OrderTransfersDTO executeTransfer(OrderTransfersDTO orderTransfers) {
        String sourceAccount = validateAccount(orderTransfers.getSourceAccount());
        String accountNumber = validateAccount(orderTransfers.getDestinationAccount());
        // Date scheduleDate = orderTransfers.getScheduleDate();
        // Date transferDate = orderTransfers.getTransferDate();

        BaseTransfer transfer = null;  
        if (orderTransfers.getTransferType().equals("A") ) {
            transfer = new TransferA();
        } else if (orderTransfers.getTransferType().equals("b")) {
            transfer = new TransferB();
        } else if (orderTransfers.getTransferType().equals("C") ) {
            transfer = new TransferC();
        } else if (orderTransfers.getTransferType().equals("D")) {
            transfer = new TransferB();
        }

        Account accountSource = accountRepo.findByAccountNumber(sourceAccount)
        .orElseThrow(() -> new RuntimeException("Número da conta inválido"));

        Account accountDestination = accountRepo.findByAccountNumber(accountNumber)
        .orElseThrow(() -> new RuntimeException("Número da conta inválido"));

        transfer.setUsersAccont(accountSource, accountDestination);
        transfer.execute(orderTransfers);
        OrderTransfers result = orderRepo.save(orderTransfers.parserModel());
        return new OrderTransfersDTO(result);
    }

    private String validateAccount(String account) {
        Pattern pattern = Pattern.compile("[0-9]{6}");
        Matcher matcher = pattern.matcher(account);
        if ( !matcher.matches()) new RuntimeException("Número da conta inválido");
        return account;
    }
}
