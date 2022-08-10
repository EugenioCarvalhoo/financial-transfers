package br.com.bank.domain;

import java.util.Date;

import br.com.bank.model.OrderTransfers;
import br.com.bank.model.User;

public abstract class BaseTransfer {
    protected User current;
    protected User destination;

    public void setUsersAccont(User current, User destination) {
        this.current = current;
        this.destination = destination;
    }

    public abstract void execute(OrderTransfers orderTransfers);
}
