package me.wonwoo.web;

import me.wonwoo.domain.Reservation;
import me.wonwoo.domain.Screen;
import me.wonwoo.dto.ReservationDto;
import me.wonwoo.service.ReservationService;
import me.wonwoo.service.ScreenService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reservation")
public class ReservationController {

    @Autowired
    private ScreenService screenService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ReservationDto.ReservationResponse saveReservation(@RequestBody ReservationDto.ReservationRequest reservationRequest){
        Reservation reservation = reservationService.reservation(reservationRequest);
        return modelMapper.map(reservation, ReservationDto.ReservationResponse.class);
    }
}
