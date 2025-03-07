package br.com.fiap.hotel_manager.exception;

public class RoomAlreadyBookedException extends RuntimeException{
    public RoomAlreadyBookedException(String message) {super(message);}
}
