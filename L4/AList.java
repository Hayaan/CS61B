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
    public int[] values;    
    private int size;

    /** Creates an empty arraylist */
    public AList() {
        this.values = new int[4];
        size = 0;
    }

    /** Adds an integer to the back of the arraylist */
/*  1 3 2 4 55 332 23 + 45
    0 1 2 3 4 5 6  7
    size = 8
    1 3 2 4 55 332 23 45
    0 1 2 3 4 5 6  7  8
    size = 9
*/
    public void addLast(int num) {
        if (size == this.values.length) {
            int[] newArr = new int[size+1];
            System.arraycopy(values, 0, newArr, 0, values.length);
            this.values = newArr;
        }
        this.values[size] = num;
        size++;
    }

    /** Returns the last value of the arraylist */
    public int getLast() {
        return this.values[size-1];
    }

    /** Return value @ ith index in the array list. Zero-based */
    public int get(int i) {
        return this.values[i];
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

    public static void main(String[] args) {
        AList testList = new AList();
        for (int i = 0; i < testList.values.length; i++) {
        testList.addLast(i);
        }
        testList.addLast(234);
        System.out.println(testList.size());
        System.out.println(testList.removeLast());
    }
}