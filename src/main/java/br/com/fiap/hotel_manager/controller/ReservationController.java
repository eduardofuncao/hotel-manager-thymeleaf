package br.com.fiap.hotel_manager.controller;

import br.com.fiap.hotel_manager.controller.dto.ReservationDTO;
import br.com.fiap.hotel_manager.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservations")
public class ReservationController {
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        return ResponseEntity.ok(reservationService.saveReservation(reservationDTO));
    }

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }

    @PutMapping
    public ResponseEntity<ReservationDTO> updateReservation(@PathVariable Long id, @RequestBody ReservationDTO reservationDTO) {
        ReservationDTO existingReservation = reservationService.getReservationById(id);
        existingReservation.setCheckinDate(reservationDTO.getCheckinDate());
        existingReservation.setCheckoutDate(reservationDTO.getCheckoutDate());
        existingReservation.setRoomId(reservationDTO.getRoomId());
        existingReservation.setClientId(reservationDTO.getClientId());
        return ResponseEntity.ok(reservationService.saveReservation(existingReservation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservationById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
