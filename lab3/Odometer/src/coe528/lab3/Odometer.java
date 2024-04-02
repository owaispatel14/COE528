package coe528.lab3;

/**
 *
 * @author Owais
 */
public class Odometer {
    private int[] digits;
    private int numOfDigits;

    public Odometer(int numOfDigits) {
        if (numOfDigits < 1) {
            throw new IllegalArgumentException("Number of digits in odometer must be at least 1");
        }
        this.numOfDigits = numOfDigits;
        this.digits = new int[numOfDigits];
        reset();
    }

    public void increment() {
        for (int i = numOfDigits - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
    }

    public void decrement() {
        for (int i = numOfDigits - 1; i >= 0; i--) {
            if (digits[i] > 0) {
                digits[i]--;
                break;
            } else {
                digits[i] = 9;
            }
        }
    }

    public void reset() {
        for (int i = 0; i < numOfDigits; i++) {
            digits[i] = 0;
        }
    }

    public String count() {
        String result = "";
        for (int digit : digits) {
            result += Integer.toString(digit);
        }
        return result;
    }
}