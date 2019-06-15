package idv.kuma.DateAndTime;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;

public class LocalDateTry {


    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2019, Month.MAY,3);
        System.out.println(date);
        System.out.println(date.getDayOfWeek());
        System.out.println(date.lengthOfMonth());
        System.out.println(date.isLeapYear());


    }
}
