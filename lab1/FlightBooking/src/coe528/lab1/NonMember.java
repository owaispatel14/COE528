package coe528.lab1;

/**
 *
 * @author Owais Patel 501181250
 */
public class NonMember extends Passenger {
   
    //Constructor with only name and age since there is no need for years of membership
    public NonMember (String name, int age){
        super(name, age); //Uses superclass to get name and age
    }
    
    //Overrides the applyDiscount method and only applies a senior discount
    @Override
    public double applyDiscount (double p){
        if (age > 65){
            return p * 0.90;
        }
        else{
            return p ;
        }
    }
}
