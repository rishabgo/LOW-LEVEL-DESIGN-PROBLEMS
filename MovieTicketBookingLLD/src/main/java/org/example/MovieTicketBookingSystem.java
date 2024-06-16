package org.example;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MovieTicketBookingSystem {
    List<Movie> movies = new ArrayList<>();
    List<Theatre> theatres = new ArrayList<>();
    Map<Integer, Booking> bookingMap = new HashMap<>();
    private static MovieTicketBookingSystem instance = null;

    private MovieTicketBookingSystem() {}

    public static MovieTicketBookingSystem getInstance() {
        if (instance == null) {
            synchronized (MovieTicketBookingSystem.class) {
                if (instance == null) {
                    instance = new MovieTicketBookingSystem();
                }
            }
        }
        return instance;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void bookSeats(User user, Show show, List<Seat> seats) {
        for(Seat seat : seats) {
            if(seat.getSeatStatus().equals(SeatStatus.BOOKED)) {
                throw new IllegalStateException("Seat already booked " + seat.getId());
            }
        }
    }

}
