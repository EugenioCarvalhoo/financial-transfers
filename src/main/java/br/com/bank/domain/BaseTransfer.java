package br.com.bank.domain;

import java.util.Date;

import javax.security.auth.login.AccountNotFoundException;

import br.com.bank.dto.OrderTransfersDTO;
import br.com.bank.model.Account;
import br.com.bank.model.OrderTransfers;
import br.com.bank.model.User;

public abstract class BaseTransfer {
    protected Account current;
    protected Account destination;

    public void setUsersAccont(Account current, Account destination) {
        this.current = current;
        this.destination = destination;
    }

    public abstract void execute(OrderTransfersDTO orderTransfers);
}
