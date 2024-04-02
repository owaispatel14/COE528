package coe528.lab3;

/**
 *
 * @author Owais
 */
public class LinkedDigitCounter extends AbstractCounter {
    private Counter leftNeighbor; // Reference to the left neighbor counter

    // Constructor taking the left neighbor counter as an argument
    public LinkedDigitCounter(Counter leftNeighbor) {
        this.leftNeighbor = leftNeighbor;
    }

    // Implementation of the increment method from the Counter interface
    @Override
    public void increment() {
        if (value < 9) {
            value++;
        } else {
            value = 0;
            if (leftNeighbor != null) {
                leftNeighbor.increment();
            } else {
                // Reset the counter to 0 if there's no left neighbor
                value = 0;
            }
        }
    }

    // Implementation of the decrement method from the Counter interface
    @Override
    public void decrement() {
        if (value > 0) {
            value--;
        } else {
            value = 9;
            if (leftNeighbor != null) {
                leftNeighbor.decrement();
            } else {
                // Reset the counter to 9 if there's no left neighbor
                value = 9;
            }
        }
    }
}