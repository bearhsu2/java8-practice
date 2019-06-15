package idv.kuma.DateAndTime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.TemporalAmount;

public class InstanceDurationPeriodTry {
    public static void main(String[] args) {

        Instant instant1 = Instant.ofEpochSecond(3);
        Instant instant2 = Instant.ofEpochSecond(4);
        System.out.println(Duration.between(instant1, instant2));

        System.out.println(Period.between(LocalDate.of(2019,11,13), LocalDate.of(2019,11,14)));

        Duration threeDays = Duration.ofDays(3);
        Duration newDuration = Duration.from(threeDays);



    }
}
