package br.com.bank.dto;

import java.math.BigDecimal;

import br.com.bank.model.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDTO {

    private Long id;
    private String accountNumber;
    private BigDecimal amount;
    private UserDTO user;

    public AccountDTO(Account account) {
        id = account.getId();
        accountNumber = account.getAccountNumber();
        amount = account.getAmount();
        if (account.getUser() != null) {
            user = new UserDTO(account.getUser());
        }
    }


    public Account parseModel() {
        Account account = new Account();
        account.setId(id);
        account.setAccountNumber(accountNumber);
        account.setAmount(amount);
        if (getUser() != null) {
            account.setUser(user.parserModel());
        }
        return account;
    }

}
