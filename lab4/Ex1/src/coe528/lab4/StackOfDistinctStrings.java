package coe528.lab4;

//Owais Patel
import java.util.ArrayList;

public class StackOfDistinctStrings {
// Overview: StacksOfDistinctStrings are mutable, bounded
// collection of distinct strings that operate in
// LIFO (Last-In-First-Out) order.
//
// The abstraction function is:
// a) Write the abstraction function here
// AF(items): a stack which is represented by the class "StackOfDistinctStrings" 
//            which contains the elements in the "items" ArrayList.           
//
//
// The rep invariant is:
// b) Write the rep invariant here
// The items in the stack must not contain duplicate elements. This must be true. 
//     

    private ArrayList<String> items;
// constructor

    public StackOfDistinctStrings() {
// EFFECTS: Creates a new StackOfDistinctStrings object
        items = new ArrayList<String>();
    }

    public void push(String element) throws Exception {
// MODIFIES: this
// EFFECTS: Appends the element at the top of the stack
// if the element is not in the stack, otherwise
// does nothing.
        if (element == null) {
            throw new Exception();
        }
        if (false == items.contains(element)) {
            items.add(element);
        }
    }

    public String pop() throws Exception {
// MODIFIES: this
// EFFECTS: Removes an element from the top of the stack
        if (items.size() == 0) {
            throw new Exception();
        }
        return items.remove(items.size() - 1);
    }
    
    public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
// c) Write the code for the repOK() here
        for(int i = 0; i<items.size(); i++){
            for(int j = i + 1; j < items.size(); j++){
                if(items.get(i).equals(items.get(j))){
                    return false;
                }
            }
        }
        return true;
    }

    public String toString() {
// EFFECTS: Returns a string that contains the strings in the
// stack and the top element. Implements the
// abstraction function.
// d) Write the code for the toString() here
    return "StackofDistinctStrings" + items.toString();
    }
}
