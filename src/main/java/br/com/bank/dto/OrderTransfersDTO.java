package br.com.bank.dto;

import java.math.BigDecimal;
import java.util.Date;

import br.com.bank.model.OrderTransfers;
import br.com.bank.model.User;
import br.com.bank.utils.DateUtil;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class OrderTransfersDTO {

    private Long id;
    private String  transferType;
    private String  sourceAccount;
    private String destinationAccount;
    private BigDecimal transferValue;
    private Date transferDate;
    private Date scheduleDate;
    private UserDTO user;

    public OrderTransfersDTO(OrderTransfers model) {
        id = model.getId();
        transferType = model.getTransferType();
        destinationAccount = model.getDestinationAccount();
        sourceAccount = model.getSourceAccount();
        transferValue = model.getTransferValue();
        transferDate = model.getTransferDate();
        scheduleDate = model.getScheduleDate();
        if (model.getUser() != null) {
            user = new UserDTO(model.getUser());
        }
    }

    public OrderTransfers parserModel() {
        OrderTransfers model = new OrderTransfers();
        model.setId(id);
        model.setTransferType(transferType);
        model.setDestinationAccount(destinationAccount);
        model.setTransferValue(transferValue);
        if (getUser() != null) {
            model.setUser(getUser().parserModel());
        }
        return model;
    }
     
}
