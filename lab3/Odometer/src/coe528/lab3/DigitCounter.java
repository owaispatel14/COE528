package coe528.lab3;

/**
 *
 * @author Owais
 */
public class DigitCounter extends AbstractCounter {

    // Implementation of the increment method from the Counter interface
    @Override
    public void increment() {
        if (value < 9) {
            value++;
        } else {
            value = 0;
        }
    }

    // Implementation of the decrement method from the Counter interface
    @Override
    public void decrement() {
        if (value > 0) {
            value--;
        } else {
            value = 9;
        }
    }
}
