public class TestAList {
    public static void main(String[] args) {
        AList testList = new AList();
        for (int i = 1; i <= 100; i++) {
            testList.addLast(i);
        }
        for (int i = 0; i <= 100; i++) {
            System.out.println(testList.removeLast());
        }
    }
}