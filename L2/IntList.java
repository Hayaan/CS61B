class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }
    /** Return the size of the list using recursion! */
    public int size() {
        if (rest == null) {     // If the rest is null, you're at the last node.
            return 1;
       }    
       return 1 + this.rest.size(); // Else, recursively call size on rest.
    }
    
    /** Returns the size of the list w/o recursion*/
    public int iterativeSize() {
        IntList p = this;       // Create a pointer variable.
        int totalSize = 0;

        while (p != null) {
            totalSize++;
            p = p.rest;
        }
        return totalSize;
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        
        System.out.println(L.size());
        System.out.println(L.iterativeSize());
    }
}
