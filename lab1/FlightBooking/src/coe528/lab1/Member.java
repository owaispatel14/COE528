package coe528.lab1;

/**
 *
 * @author Owais Patel 501181250
 */
//Subclass of Passenger class
public class Member extends Passenger {
    int yearsOfMembership;
    
    //Constructor for member
    public Member (String name, int age, int yearsOfMembership){
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
    }
    
    //overriding discount method and applies discounts according to yearsOfMembership
    @Override
    public double applyDiscount (double p){
        if (yearsOfMembership > 5){
            return p * 0.50;
        }
        else if (1 < yearsOfMembership && yearsOfMembership <= 5){
            return p * 0.90;
        }
        else{
            return p ;
        }
    }
}
