package br.com.bank.domain;

import java.math.BigDecimal;
import java.util.Date;

import br.com.bank.dto.OrderTransfersDTO;
import br.com.bank.model.OrderTransfers;
import br.com.bank.model.User;
import br.com.bank.utils.Calculate;

import static br.com.bank.utils.DateUtil.parseString;

public class TransferA extends BaseTransfer {

    private static final Integer tax = 3;
    private static final Integer adtional = 3;

    @Override
    public void execute(OrderTransfersDTO orderTransfers) {
        Date scheduleDate = orderTransfers.getScheduleDate();
        Date transferDate = orderTransfers.getTransferDate();
        if (parseString(scheduleDate)
                .equals(parseString(transferDate))) {
            BigDecimal transferValue = orderTransfers.getTransferValue();
            BigDecimal currentAmount = current.getAmount()
                    .subtract(transferValue);
            current.setAmount(currentAmount);
    
            transferValue =  Calculate.subtractPercentage(transferValue, new BigDecimal(tax))
            .subtract(new BigDecimal(adtional));
            BigDecimal destinationAmount = destination.getAmount()
            .add(transferValue);
            destination.setAmount(destinationAmount);
        }
        throw new RuntimeException("Não existe taxa applicavel para este tipo de tranferêcia");
    }

}
