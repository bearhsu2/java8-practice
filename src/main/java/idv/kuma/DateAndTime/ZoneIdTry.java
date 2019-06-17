package idv.kuma.DateAndTime;

import java.time.*;
import java.util.TimeZone;

public class ZoneIdTry {

    public static void main(String[] args) {
        System.out.println(TimeZone.getDefault().toZoneId());

        ZoneId romeZone = ZoneId.of("Europe/Rome");
        System.out.println(romeZone);

        LocalDateTime dateTime1 = LocalDateTime.of(2014, Month.SEPTEMBER, 18, 13, 45,31,1_000_000);
        ZonedDateTime zonedDateTime1 = dateTime1.atZone(romeZone);
        System.out.println(zonedDateTime1);

        LocalDateTime dateTime2 = LocalDateTime.now();
        ZonedDateTime zonedDateTime2 = dateTime2.atZone(romeZone);
        System.out.println(zonedDateTime2);


        // ZoneOffset extends ZoneId
        // Can use it to create ZonedDateTime or OffsetDateTime
        // Prefer NOT TO USE: it doesn't consider daylight saving.
        ZoneOffset newYorkOffset = ZoneOffset.of("-05:00");
        System.out.println(dateTime2.atZone(newYorkOffset));
        System.out.println(OffsetDateTime.of(dateTime2, newYorkOffset));
    }
}
