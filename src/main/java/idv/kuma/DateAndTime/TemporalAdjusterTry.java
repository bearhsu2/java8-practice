package idv.kuma.DateAndTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjusterTry {

    public static void main(String[] args) {

        LocalDate date1 = LocalDate.of(2019,3,6);
        System.out.println(date1);
        LocalDate date2 = date1.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        System.out.println(date2);
        LocalDate date3 = date1.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(date3);

    }
}
