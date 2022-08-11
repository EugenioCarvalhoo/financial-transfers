package br.com.bank.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.bank.model.OrderTransfers;
import br.com.bank.model.User;
import br.com.bank.utils.DateUtil;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class OrderTransfersDTO {

    private Long id;
    private String  transferType;
    private String  sourceAccount;
    private String destinationAccount;
    private BigDecimal transferValue;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date transferDate = DateUtil.getDate();
    @JsonFormat(pattern = "dd/MM/yyyy")
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
        model.setSourceAccount(sourceAccount);
        model.setTransferType(transferType);
        model.setScheduleDate(scheduleDate);
        model.setTransferDate(transferDate);
        model.setDestinationAccount(destinationAccount);
        model.setTransferValue(transferValue);
        if (getUser() != null) {
            model.setUser(getUser().parserModel());
        }
        return model;
    }
     
}
