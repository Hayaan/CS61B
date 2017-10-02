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
        values = new int[4];
        size = 0;
    }

    /** Adds an integer to the back of the arraylist 
        If the array's max capacity has been reached,
        copies all of the values to a new array whose capacity
        is previous' array length + 1.
    */
    public void addLast(int num) {
        if (size == values.length) 
            {resize(size+1);}
        values[size] = num;
        size++;
    }
    /** Resizes array to target capacity */
    private void resize(int capacity) {
        int[] newArr = new int[capacity];
            System.arraycopy(values, 0, newArr, 0, size);
            values = newArr;
    }

    /** Returns the last value of the arraylist */
    public int getLast() {
        return values[size-1];
    }

    /** Return value @ ith index in the array list. Zero-based */
    public int get(int i) {
        return values[i];
    }

    /** Return the this of the arraylist */
    public int size() {
        return size;
    }

    /** Remove and return the last value in the arraylist */
    public int removeLast() {
        int last = getLast();
        size--;
        return last;
    }
}