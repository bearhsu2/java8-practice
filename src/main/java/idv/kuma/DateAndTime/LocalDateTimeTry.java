package idv.kuma.DateAndTime;

import java.time.*;
import java.time.temporal.ChronoField;

public class LocalDateTimeTry {


    public static void main(String[] args) {

        // Date
        LocalDate date = LocalDate.of(2019, Month.MAY,3);
        System.out.println(date);
        System.out.println(date.getDayOfWeek());
        System.out.println(date.lengthOfMonth());
        System.out.println(date.isLeapYear());
        System.out.println(date.get(ChronoField.DAY_OF_MONTH));

        // Time
        LocalTime  time = LocalTime.of(23,11,22,22);
        System.out.println(time);
        System.out.println(time.getMinute());

        // Parse
        LocalDate parsedDate = LocalDate.parse("2015-03-04");
        System.out.println(parsedDate);

        // DateTime
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        System.out.println(dateTime.getYear());

        System.out.println(date.atTime(time));
        System.out.println(time.atDate(date));

        System.out.println(dateTime.toLocalDate());
        System.out.println(dateTime.toLocalTime());



    }
}
