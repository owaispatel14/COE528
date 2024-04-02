package coe528.lab1;

/**
 *
 * @author Owais Patel 501181250
 */

public abstract class Passenger {
    String name;
    int age;
    
    public Passenger (String name, int age){
        this.name = name;
        this.age = age;
    }
    
    
    //Getter methods
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    
    //Setter methods
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }

    //abstract discount method that will be overriden by subclasses
    abstract double applyDiscount(double p); 
    
}




