public class ArrayDeque<T> {
    private T[] data;
    private int size, nextFirst, nextLast;

    public ArrayDeque() {
        data = (T[]) new Object[8];
        size = 0;
        nextFirst = 4; 
        nextLast = 5;
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> test = new ArrayDeque<>();
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < 6; i++) {
            test.addFirst(rand.nextInt(101));
            test.addLast(rand.nextInt(101));
        }

        System.out.println(test.size());

        test.printDeque();

    }
}