package br.com.bank.domain;

import java.math.BigDecimal;
import java.util.Date;

import br.com.bank.model.OrderTransfers;
import br.com.bank.utils.Calculate;
import br.com.bank.utils.DateUtil;
import br.com.bank.dto.OrderTransfersDTO;

public class TransferC extends BaseTransfer {

    private enum TaxAbove {
        DAY10("8.2", 11),
        DAY20("6.9",21),
        DAY30("4.7", 31),
        DAY40("1.7", 41);

        private String percent;
        private Integer aboveDays;

        TaxAbove(String percent, Integer aboveDays) {
            this.percent = percent;
            this.aboveDays = aboveDays;
        }

        public String percent() {
            return percent;
        }

        public Integer aboveDays() {
            return aboveDays;
        }
    }

    @Override
    public void execute(OrderTransfersDTO orderTransfers) {
        Date scheduleDate = orderTransfers.getScheduleDate();
        Date transferDate = orderTransfers.getTransferDate();
        BigDecimal transferValue = orderTransfers.getTransferValue();
        if (DateUtil.isValidCompare(transferDate, scheduleDate, TaxAbove.DAY10.aboveDays())) {
            dispatchTax(TaxAbove.DAY10, transferValue);
            return;
        }
        if (DateUtil.isValidCompare(transferDate, scheduleDate, TaxAbove.DAY20.aboveDays())) {
            dispatchTax(TaxAbove.DAY20, transferValue);
            return;
        }
        if (DateUtil.isValidCompare(transferDate, scheduleDate, TaxAbove.DAY30.aboveDays())) {
            dispatchTax(TaxAbove.DAY30, transferValue);
            return;
        }
        if (DateUtil.isValidCompare(transferDate, scheduleDate, TaxAbove.DAY40.aboveDays())) {
            dispatchTax(TaxAbove.DAY40, transferValue);
            return;
        }
        throw new RuntimeException("Não existe taxa applicavél para este tipo de tranferência");
    }

    private void dispatchTax(TaxAbove taxAbove, BigDecimal transferValue) {
            BigDecimal currentAmount = current.getAmount()
                    .subtract(transferValue);
            current.setAmount(currentAmount);

            transferValue = Calculate.subtractPercentage(transferValue, new BigDecimal(taxAbove.percent()));
            BigDecimal destinationAmount = destination.getAmount()
                    .add(transferValue);
            destination.setAmount(destinationAmount);
    }
    
}
