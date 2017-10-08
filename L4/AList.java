public class AList {
    private int[] data;
    private int size;

    public AList() {
        this.data = new int[50];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public int get(int i) {
        return this.data[i];
    }

    public int getLast() {
        return this.data[size-1];
    }

    public void resize() {
        // The assigned value is only used in the event of the ALIst being reduced in size/
        int capacity = (int) (this.size*.5) + 1;
        if (this.size == this.data.length) {
            capacity = this.size*2;
            int[] largerAList = new int[capacity];
            System.arraycopy(); @TODO
        } else if (0.5*this.size >= this.data.length) {
            int[] smallerAList = new int[capacity];
            System.arraycopy(this.data, 0, smallerAList, 0, this.size);
        }
    }

    public void addLast(int value) {
        this.data[size] = value;
        this.size++;
        resize();    
    }

    public int removeLast() {
        int last = getLast();
        return last;
    }
}