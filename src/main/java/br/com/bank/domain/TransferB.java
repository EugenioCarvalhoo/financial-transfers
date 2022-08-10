package br.com.bank.domain;

import java.math.BigDecimal;
import java.util.Date;

import br.com.bank.model.OrderTransfers;
import br.com.bank.utils.Calculate;
import br.com.bank.utils.DateUtil;

public class TransferB  extends BaseTransfer {

    private static final Integer adtional = 12;

    @Override
    public void execute(OrderTransfers orderTransfers) {
        Date scheduleDate = orderTransfers.getScheduleDate();
        Date transferDate = orderTransfers.getTransferDate();

        if (DateUtil.isValidCompare(transferDate, scheduleDate, 10)) {
            BigDecimal transferValue = orderTransfers.getTransferValue();
            BigDecimal currentAmount = current.getAccount().getAmount()
                    .subtract(transferValue);
            current.getAccount().setAmount(currentAmount);
    
            transferValue =  transferValue.subtract(new BigDecimal(adtional));
            BigDecimal destinationAmount = destination.getAccount().getAmount()
            .add(transferValue);
            destination.getAccount().setAmount(destinationAmount);
        }

        throw new RuntimeException("Não existe taxa applicavel para este tipo de tranferêcia");
    }

}
