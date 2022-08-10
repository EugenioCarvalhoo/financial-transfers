package br.com.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.datetime.standard.DateTimeFormatterFactory;

import br.com.bank.model.Account;
import br.com.bank.model.User;
import br.com.bank.utils.DateUtil;

@ExtendWith(MockitoExtension.class)
class BankApplicationTests {

	@Test
	void contextLoads() {

	}

}
