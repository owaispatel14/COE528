package coe528.lab1;
import java.util.ArrayList;

/**
 *
 * @author Owais Patel 501181250
 */
public class Manager {
    
    ArrayList<Flight> flight= new ArrayList<Flight>();
    ArrayList<Ticket> ticket= new ArrayList<Ticket>();
    int ticketNum = 0;
    
    //Populates the array of flights
    public void createFlights(){
        
        flight.add(new Flight(235, 300, "Toronto", "New York", "Jan 23, 18:00", 600.00));
        flight.add(new Flight(545, 150, "Monaco", "Singapore", "May 14, 08:00", 1000.00));
        flight.add(new Flight(694, 90, "Barbados", "Montreal", "Oct 01, 23:00", 820.00));

    }
    
    //Displays All Available Flights
    public void displayAvailableFlights(String origin, String destination){
        for (Flight o:this.flight){
            if (o.getOrigin().equals(origin) && o.getDestination().equals(destination) && o.getNumberOfSeatsLeft()>0){
                System.out.println(o.toString());
            }
        }
        
    }
    
    //Returns the flight for specified flight number
    public Flight getFlight(int flightNumber){
        for(Flight o : this.flight) {
            if(o.getFlightNumber() == flightNumber) {
                return o;
                
            }
        }
        return null;
    }
    
    //Tries to find a flight with the corresponding flight number and then tries to book a seat
    public void bookSeat(int flightNumber, Passenger p) {
        Flight f = getFlight(flightNumber);
        if(f!=null){
            ticket.add(new Ticket(p, f, p.applyDiscount(f.getOriginalPrice())));
            System.out.println(ticket.get(ticketNum).toString());
            ticketNum++;
        }
        else{
            System.out.println("Sorry, the flight number associated with passenger " + p.getName() +" does not exist.");
        }
            
    }
    
    public static void main (String[] args){
         
        Manager owais = new Manager();
        
        owais.createFlights();
        
        Passenger ahmed = new Member("Ahmed", 65, 5);
        Passenger zaryan = new NonMember("Zaryan", 20);
        Passenger rayaan = new NonMember("Rayyan", 70);
        
        System.out.println("These are all the flights available.");
        owais.displayAvailableFlights("Toronto", "New York");
        owais.displayAvailableFlights("Monaco", "Singapore");
        owais.displayAvailableFlights("Barbados", "Montreal");
        System.out.println("");
        
        System.out.println("These are the flights for the flight numbers");
        System.out.println(owais.getFlight(235).toString());
        System.out.println(owais.getFlight(545).toString());
        System.out.println(owais.getFlight(694).toString());
        System.out.println("");
        
        System.out.println("These are the issued tickets:");
        owais.bookSeat(236, ahmed);
        owais.bookSeat(545, zaryan);
        owais.bookSeat(694, rayaan);
        
        
        
    }
    
    
}
