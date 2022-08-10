package br.com.bank.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import net.bytebuddy.TypeCache.Sort;

public class DateUtil {
    private final static String TIME_ZONE = "america/sao_paulo";
    private final static Long BASE_DAYS = 86400000l;
    private final static String PATTERN = "dd/MM/yyyy";
    
    public static Date getDate() {
		return getCalendar().getTime();
    }

    private static Calendar getCalendar() {
        Calendar date = Calendar.getInstance();
		date.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));
        return date;
    }

    public static Boolean isValidCompare(Date source, Date compare, Integer days) {
       return getDifferDate(source, compare) <= BASE_DAYS * days;
    }

    private static Long getDifferDate(Date source, Date compare) {
        BigDecimal differ = new BigDecimal(compare.getTime()).subtract(new BigDecimal(source.getTime())); 
        return differ.longValue();
    }

    public static String parseString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN);
		return simpleDateFormat.format(date);
    }
    
}
