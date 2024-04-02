package coe528.lab1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Owais Patel 501181250
 */
public class FlightTest {
    
    
    @Test
    public void testCorrectConstructor(){
        System.out.println("Testing the Constructor with a valid input");
        Flight f = new Flight(52, 200, "Toronto", "New York", "Jan 23, 18:00", 500.00);
        Object expResults = "Flight " + f.getFlightNumber() + ", " + f.getOrigin() + " to " + f.getDestination() + ", " + f.getDepartureTime() + ", original price: $ " + f.getOriginalPrice();
        assertEquals(expResults, f.toString());
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void testIncorrectConstructor(){
        System.out.println("Testing the Constructor with an invalid input");
        Flight f = new Flight(52, 200, "Toronto", "Toronto", "Jan 23, 18:00", 500.00);

    }
    
    
    @Test
    public void testBookASeat(){
        System.out.println("Testing the bookASeat method");
        Flight f = new Flight(52, 200, "Toronto", "New York", "Jan 23, 18:00", 500.00);
        f.bookASeat();
        assertEquals(true, f.bookASeat());
    }
    
    
    @Test
    public void testGettersAndSetters() {
        System.out.println("Testing the getters and setters.");
        Flight f = new Flight(52, 200, "Toronto", "New York", "Jan 23, 18:00", 500.00);
        
        f.setFlightNumber(39);
        f.setCapacity(250);
        f.setNumberOfSeats(140);
        f.setOrigin("Monaco");
        f.setDestination("Miami");
        f.setDepartureTime("Jan 10, 20:00");
        f.setOriginalPrice(600.00);
        
        assertEquals(39, f.getFlightNumber());
        assertEquals(250, f.getCapacity());
        assertEquals(140, f.getNumberOfSeatsLeft());
        assertEquals("Monaco", f.getOrigin());
        assertEquals("Miami",f.getDestination());
        assertEquals("Jan 10, 20:00", f.getDepartureTime());
        assertEquals(600.00, f.getOriginalPrice(), 0.0001);
    }

    @Test
    public void testToString (){
        System.out.println("Testing the toString method.");
        Flight f = new Flight(52, 200, "Toronto", "New York", "Jan 23, 18:00", 500.00);
        assertEquals("Flight 52, Toronto to New York, Jan 23, 18:00, original price: $ 500.0",f.toString());
    }
}
