package org.example.FileHandlingWithMultiThreading;

class Flight {
    String flight_id;
    int curr_altitude_fit;
    String destination_airport_code;
    String dept_time;
    String curr_location;

    public Flight(String flight_id,int curr_altitude_fit, String destination_airport_code, String dept_time, String curr_location) {
        this.flight_id = flight_id;
        this.curr_altitude_fit = curr_altitude_fit;
        this.destination_airport_code = destination_airport_code;
        this.dept_time = dept_time;
        this.curr_location = curr_location;
    }

    public String getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(String flight_id) {
        this.flight_id = flight_id;
    }

    public int getCurr_altitude_fit() {
        return curr_altitude_fit;
    }

    public void setCurr_altitude_fit(int curr_altitude_fit) {
        this.curr_altitude_fit = curr_altitude_fit;
    }

    public String getDestination_airport_code() {
        return destination_airport_code;
    }

    public void setDestination_airport_code(String destination_airport_code) {
        this.destination_airport_code = destination_airport_code;
    }

    public String getDept_time() {
        return dept_time;
    }

    public void setDept_time(String dept_time) {
        this.dept_time = dept_time;
    }

    public String getCurr_location() {
        return curr_location;
    }

    public void setCurr_location(String curr_location) {
        this.curr_location = curr_location;
    }

    @Override
    public String toString() {
        return "{" +
                "flight_id='" + flight_id + '\'' +
                ", curr_altitude_fit='" + curr_altitude_fit + '\'' +
                ", dept_time='" + dept_time + '\'' +
                ", curr_location='" + curr_location + '\'' +
                '}';
    }
}
