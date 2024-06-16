package org.example;

public class Seat {
    private final int id;
    private final int row;
    private final double price;
    private final SeatCategory seatCategory;
    private final SeatStatus seatStatus;

    public Seat(int id, int row, double price, SeatCategory seatCategory, SeatStatus seatStatus) {
        this.id = id;
        this.row = row;
        this.price = price;
        this.seatCategory = seatCategory;
        this.seatStatus = seatStatus;
    }

    public int getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public double getPrice() {
        return price;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }
}
