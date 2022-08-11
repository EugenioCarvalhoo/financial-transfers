package br.com.bank.dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import br.com.bank.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String fristName;
    private String lastName;
    private AccountDTO account;
    private List<OrderTransfersDTO> orderTransfers = new ArrayList<>();

    public UserDTO(User user) {
        id = user.getId();
        fristName = user.getFristName();
        lastName = user.getLastName();
        if (user.getAccount() != null) {
            account = new AccountDTO(user.getAccount());
        }
        if (!user.getOrderTransfers().isEmpty()) {
            orderTransfers = user.getOrderTransfers()
            .stream().map(el -> new OrderTransfersDTO(el))
            .collect(Collectors.toList());
        }

    }

    public User parserModel() {
        User user = new User();
        user.setId(id);
        user.setFristName(fristName);
        user.setLastName(lastName);
        if (getAccount() != null) {
            user.setAccount(account.parseModel());
        }
        if (!getOrderTransfers().isEmpty()) {
            user.getOrderTransfers().addAll(
                getOrderTransfers().stream()
                .map(el -> el.parserModel())
                .collect(Collectors.toList())
            );
        }
        return user;
    }

}
