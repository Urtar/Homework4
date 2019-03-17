package pl.coderslab;

public class Flight {
    private String departure;
    private String arrival;
    private String arrivalTime;
    private Double price;

    @Override
    public String toString() {
        return "Flight[ departure=" + departure + " arrival=" + arrival + " arrivalTime=" + arrivalTime + " price=" + price + "]";
    }

    public Flight() {
    }

    public Flight(String departure, String arrival, String arrivalTime, Double price) {
        this.departure = departure;
        this.arrival = arrival;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
