package org.example;

import java.time.*;

public class LocalDateCode {
    public  static void main(String[] args){
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(date.plusDays(10));
        System.out.println(date.isLeapYear());

        LocalDate date1 = LocalDate.of(2025,11,01);
        System.out.println(date1);
        System.out.println();


        Period period = Period.between(date1,date);
        System.out.println(period);

        LocalTime timestart = LocalTime.of(9,50);
        LocalTime timeend = LocalTime.of(10,50);
        Duration duration = Duration.between(timestart,timeend);
        System.out.println(duration.toHours());

        LocalDateTime datetime = LocalDateTime.now();
        System.out.println(datetime);

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(zonedDateTime);

        Instant instant = Instant.now();
        System.out.println(instant);   //UTC

    }
}
