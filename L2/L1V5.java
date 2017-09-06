class L1V5 {
// Test your understanding of the Golden Rule of Equals (GRoE)
    public static void main(String[] args) {
        Walrus walrus = new Walrus(3500, 10.5);
        int x = 9;
        doStuff(walrus, x);
        System.out.println(walrus);
        System.out.println(x);
    }

    public static void doStuff(Walrus W, int x) {
        W.weight = W.weight - 100;
        x = x - 5;
    }
}
// Does the call to doStuff(walrus, x) have an effect on walrus and/or main's x?// B. walrus will lose 100 lbs, but main's will not change.
//
// https://cscircles.cemc.uwaterloo.ca/java_visualize/#mode=display
