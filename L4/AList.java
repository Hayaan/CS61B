// Arrays > LinkedLists w/r/t accessing data at a certain index
// which is why for a large list, it might be beneficial to use 
// ArrayLists rather than your generic LinkedList that makes use of pointers
// to have O(1) access time complexity.

/* Methods & invariants:
    addLast():
        the next item we want to add, will go into position (size)
    getLast():
        the item we want to return is in position (size-1)
    removeLast()
    get(int i)
    size:
        # of items in the arraylist should == size
*/
public class AList {
    // These fields should've been private.
    private int[] values;    
    private int size;

    /** Creates an empty arraylist */
    public AList() {
        items = new int[100];
        size = 0;
    }

    /** Adds an integer to the back of the arraylist */
    public void addLast(int num) {
        values[size] = num;
        size++;
    }

    /** Returns the last value of the arraylist */
    public int getLast() {
        return values[size-1];
    }

    /** Return value @ ith index in the array list. Zero-based */
    public int get(int i) {
        return values[i];
    }

    /** Return the size of the arraylist */
    public int size() {
        return this.size;
    }

    /** Remove and return the last value in the arraylist */
    public int removeLast() {
        int value = values[size-1];
        values[size-1] = 0;
        size--;
        return value;
    }
}