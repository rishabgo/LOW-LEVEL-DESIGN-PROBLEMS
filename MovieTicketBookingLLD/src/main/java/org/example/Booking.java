package org.example;

import java.util.List;

public class Booking {
    private final int id;
    private final BookingStatus bookingStatus;
    private final User user;
    private final List<Seat> bookedSeats;
    private final double totalPrice;
    private final Show show;
    private final Theatre theatre;

    public Booking(int id, BookingStatus bookingStatus, User user, List<Seat> bookedSeats, double totalPrice, Show show, Theatre theatre) {
        this.id = id;
        this.bookingStatus = bookingStatus;
        this.user = user;
        this.bookedSeats = bookedSeats;
        this.totalPrice = totalPrice;
        this.show = show;
        this.theatre = theatre;
    }

    public int getId() {
        return id;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public User getUser() {
        return user;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Show getShow() {
        return show;
    }

    public Theatre getTheatre() {
        return theatre;
    }
}
