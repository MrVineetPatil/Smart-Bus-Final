package com.example.smartbus;

public class Routes {

    private String Stop_name;
    private String seats;

    public Routes(String stop_name, String seats) {
        this.Stop_name = stop_name;
        this.seats = seats;
    }

    public String getStop_name() {
        return Stop_name;
    }

    public void setStop_name(String stop_name) {
        this.Stop_name = stop_name;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }
}
