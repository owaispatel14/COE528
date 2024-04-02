package coe528.lab1;

/**
 *
 * @author Owais Patel 501181250
 */
public class Ticket {
    
   private Passenger passenger;
   private Flight flight;
   private double price;
   private int ticketNumber;
   private static int number = 1;
   
   //Constructor
   public Ticket (Passenger p, Flight f, double price){
       this.passenger = p;
       this.flight = f;
       this.price = price;      
       ticketNumber = number;
       number++;
   }
   
   //Getter methods
   public Passenger getPassenger(){
       return this.passenger;
   } 
   public Flight getFlight(){
       return this.flight;
   }
   public double getPrice(){
       return this.price;
   }
   public int getTicketNumber(){
       return this.ticketNumber;
   }
   public static int getNumber(){
       return number;
   }
   
   //Setter Methods
   public void setPassenger(Passenger passenger){
       this.passenger = passenger;
   }
   public void setFlight(Flight flight){
       this.flight = flight;
   }
   public void setPrice(double price){
       this.price = price;
   }
   public void setTicketNumber(int ticketNumber){
       this.ticketNumber = ticketNumber;
   }

   
@Override
    public String toString(){
        return passenger.getName() + ": " + getFlight() + ", Ticket Price:" + getPrice();
    }

}
