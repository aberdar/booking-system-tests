package ru.ac.uniyar.bookingsystem;

import java.util.Date;
import java.util.HashMap;

/**
 * Класс, описывающий бронирование столиков в ресторане.
 * =====================================================
 * Бронирование по данным:
 * 1. Время бронирования (считаем, что принимается на текущий день)
 * 2. Число гостей
 * 3. Фамилия бронирующего
 */
public class BookingSystem {

    private final HashMap<String, HashMap<Date, Integer>> bookings = new HashMap<>();

    /**
     * Бронирует столик на имя client, на количество персон guests, на время time
     * @param time время бронирования
     * @param quests количетво человек за столом
     * @param client имя бронирующего
     */
    void book(Date time, Integer quests, String client) {
        if (!bookings.containsKey(client)) {
            bookings.put(client, new HashMap<>());
        }
        bookings.get(client).put(time, quests);
    }

    /**
     * Возвращает количество человек на которое забронированн столик на имя client и время time
     * Возвращает 0 если бронирования нет
     * @param time время бронирования
     * @param client имя бронирующего
     * @return quests (количетво человек за столом)
     */
    Integer checkStatus(Date time, String client) {
        if (!bookings.containsKey(client)) {
            return 0;
        }
        if (!bookings.get(client).containsKey(time)) {
            return 0;
        }
        return bookings.get(client).get(time);
    }
}
