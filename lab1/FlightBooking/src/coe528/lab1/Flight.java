package coe528.lab1;

/**
 *
 * @author Owais Patel 501181250
 */

public class Flight {
    
//Initialize Instance Variables
    int flightNumber, capacity, numberOfSeatsLeft;
    String origin, destination, departureTime;
    double originalPrice;
    
//Constructor
    public Flight (int flightNumber, int capacity, String origin, String destination, String departureTime, double originalPrice ){
        this.flightNumber = flightNumber;
        this.capacity = capacity;
        this.numberOfSeatsLeft = capacity;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.originalPrice = originalPrice;
           
        
        //Illegal Argument is thrown to ensure that the origin and destination are not the same. 
        if (origin.compareTo(destination)==0){
            throw new IllegalArgumentException("The origin and destination cannot be the same");
        }
    }

//Getters for each instance variable
    public int getFlightNumber(){
        return this.flightNumber;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public int getNumberOfSeatsLeft(){
        return this.numberOfSeatsLeft;
    }
    public String getOrigin(){
        return this.origin;
    }
    public String getDestination(){
        return this.destination;
    }
    public String getDepartureTime(){
        return this.departureTime;
    }
    public double getOriginalPrice(){
        return this.originalPrice;
    }
    
//Setters for each instance variable
    public void setFlightNumber(int flightNumber){
        this.flightNumber = flightNumber;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public void setNumberOfSeats(int numberOfSeats){
        this.numberOfSeatsLeft = numberOfSeats;
    }
    public void setOrigin (String origin){
        this.origin = origin; 
    }
    public void setDestination(String destination){
        this.destination = destination;
    }
    public void setDepartureTime(String departureTime){
        this.departureTime = departureTime;
    }
    public void setOriginalPrice(double originalPrice){
        this.originalPrice = originalPrice;
    }
    
    
//Decrements the numberOfSeatsLeft variable if there are still seats left and returns true or false
    public boolean bookASeat(){
        if(numberOfSeatsLeft > 0){
            numberOfSeatsLeft--;
            return true;
        }
        else{
            return false;
        }
    }

//toString method to return a string representation of a Flight object.
@Override
    public String toString(){
        return "Flight " + flightNumber + ", " + origin + " to " + destination + ", " + departureTime + ", original price: $ " + originalPrice ;
    }
    
    
}
