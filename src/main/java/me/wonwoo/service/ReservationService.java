package me.wonwoo.service;

import me.wonwoo.domain.Customer;
import me.wonwoo.domain.Reservation;
import me.wonwoo.domain.Screen;
import me.wonwoo.exception.ReservationException;
import me.wonwoo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Transactional
    public Reservation save(Long customerId, Screen screen) {

        Date screenTime = screen.getScreenTime();
        Instant instant = Instant.ofEpochMilli(screenTime.getTime());
        LocalDateTime screenLocalTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalDateTime now = LocalDateTime.now().plusMinutes(30);
        if (screenLocalTime.isBefore(now)) {
            throw new ReservationException("screen time before now time");
        }

        Reservation reservation = new Reservation();
        Customer customer = new Customer();
        customer.setId(customerId);
        reservation.setCustomer(customer);
        reservation.setPrice(screen.getDisCount());
        reservation.setScreen(screen);
        return reservationRepository.save(reservation);
    }
}
