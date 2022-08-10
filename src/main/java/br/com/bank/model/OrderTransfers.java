package br.com.bank.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.bank.utils.DateUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_transfers")
public class OrderTransfers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String  transferType;
    private Integer  sourceAccount;
    private Integer destinationAccount;
    private BigDecimal transferValue;
    @Setter(value = AccessLevel.NONE)
    private Date transferDate = DateUtil.getDate();
    private Date scheduleDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
}
