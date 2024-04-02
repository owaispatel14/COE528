package coe528.lab4;

/**
 *
 * @author Owais
 */
import java.util.LinkedList;


// The abstraction function is:
// a) Write the abstraction function here
// AF(elements): A queue of elements that is represented by the class "Queue" 
//              in which the elements are stored in the "elements" LinkedList. 
//
//
// The rep invariant is:
// b) Write the rep invariant here
//  The queue cannot have elements that are null. 
// 


public class Queue<T> {
    private LinkedList<T> elements;

    public Queue() {
        elements = new LinkedList<>();
    }

    public void enqueue(T element) {
        elements.addLast(element);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot dequeue from an empty queue");
        }
        return elements.removeFirst();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public boolean repOK() {
        for (T element : elements){
            if(element == null){
                return false;
            }
    }
        return true;
    }

    @Override
    public String toString() {
        return elements.toString();
    }

    public static void main(String[] args) {
        // Test the queue implementation
        Queue<Integer> queue = new Queue<>();
        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        // Dequeue elements
        int dequeuedElement1 = queue.dequeue(); // 10
        int dequeuedElement2 = queue.dequeue(); // 20
        // Check if the queue is empty
        boolean isEmpty = queue.isEmpty(); // false
        // Expected output
        System.out.println("Dequeued element 1: " + dequeuedElement1);
        System.out.println("Dequeued element 2: " + dequeuedElement2);
        System.out.println("Is the queue empty? " + isEmpty);
    }
}
