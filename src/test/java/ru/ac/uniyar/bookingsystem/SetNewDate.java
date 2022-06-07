package ru.ac.uniyar.bookingsystem;

import java.time.DateTimeException;
import java.util.Date;

public class SetNewDate {

    /**
     * Возвращает время бронирования
     * @param hours часов
     * @param minutes минут
     * @param seconds секунд
     * @return время записи
     */
    static public Date newDate(int hours, int minutes, int seconds) {
        Date date = new Date();

        try {
            date.setHours(hours);
            date.setMinutes(minutes);
            date.setSeconds(seconds);
        } catch (DateTimeException exception) {
            System.out.println(exception.getMessage());
        }

        return date;
    }
}
