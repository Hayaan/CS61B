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
        // The assigned value is only used in the event of the ALIst being reduced in size
        if (this.size == this.data.length) {
            int[] newArr = new int[this.size*2];
            System.arraycopy(this.data, 0, newArr, 0, size);
            this.data = newArr;            
        } else if ((this.size*0.25) <= this.data.length ) {
            int[] newArr = new int[(int) (this.size*0.5)+1];
            System.arraycopy(this.data, 0, newArr, 0, size);
            this.data = newArr;
        }
    }

    public void addLast(int value) {
        resize();
        this.data[size] = value;
        this.size++;    
    }

    public int removeLast() {
        resize();
        int last = getLast();
        size--;
        return last;
    }
}