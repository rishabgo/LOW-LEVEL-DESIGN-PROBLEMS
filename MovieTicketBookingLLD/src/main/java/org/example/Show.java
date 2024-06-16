package org.example;

import java.time.LocalDateTime;
import java.util.List;

public class Show {
    private final int id;
    private final Movie movie;
    private final Theatre theatre;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final List<Seat> seats;

    public Show(int id, Movie movie, Theatre theatre, LocalDateTime startTime, LocalDateTime endTime, List<Seat> seats) {
        this.id = id;
        this.movie = movie;
        this.theatre = theatre;
        this.startTime = startTime;
        this.endTime = endTime;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
