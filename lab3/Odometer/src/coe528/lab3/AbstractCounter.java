package coe528.lab3;

/**
 *
 * @author Owais
 */
public abstract class AbstractCounter implements Counter {
    protected int value; //Current value of the counter

    public AbstractCounter() { //The constructor to initailize the counter value to 0
        this.value = 0;
    }

    @Override
    public String count() { //Impliments the count method from the counter interface
        return Integer.toString(value);
    }

    @Override
    public void reset() { //Implements the reset methof from the counter interface
        value = 0;
    }
}
