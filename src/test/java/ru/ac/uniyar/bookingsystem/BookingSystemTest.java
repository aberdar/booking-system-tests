package ru.ac.uniyar.bookingsystem;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.assertj.core.api.Assertions.assertThat;

public class BookingSystemTest {

    BookingSystem bookingSystem = new BookingSystem();

    /**
     * Проверка на отсутствие бронирования.
     * Если бронирования нет, то возвращается 0.
     */
    @Test
    void checkStatusElseClientIsEmpty() {
        Date date = SetNewDate.newDate(18, 0, 0);
        String client = "Client";
        assertThat(bookingSystem.checkStatus(
                date,
                client
        )).isZero();
    }

    /**
     * Проверка на получение информации о бронирование.
     * Если бронирование есть, то возвращается число гостей на этой брони.
     */
    @Test
    void checkStatusElseClientIsNotEmpty() {
        Date date = SetNewDate.newDate(18, 0, 0);
        String  clientOne = "ClientOne",
                clientTwo = "ClientTwo";
        Integer questsWithClientOne = 10,
                questsWithClientTwo = 6;

        bookingSystem.book(
                date,
                questsWithClientOne,
                clientOne
        );
        bookingSystem.book(
                date,
                questsWithClientTwo,
                clientTwo
        );

        assertThat(bookingSystem.checkStatus(
                date,
                clientTwo
        )).isEqualTo(questsWithClientTwo);

        assertThat(bookingSystem.checkStatus(
                date,
                clientOne
        )).isEqualTo(questsWithClientOne);
    }
}
