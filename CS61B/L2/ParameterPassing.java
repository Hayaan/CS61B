class ParameterPassing {
    public static double average(double a, double b) {
        return (a + b) / 2;
    }

    // Copies the bits to the new scope. (The function average's scope.) 
    // Passing by value. (In Java, you always pass the bits.)
    public static void main(String[] args) {
        double x = 5.5;
        double y = 10.5;
        double avg = average(x, y);
    }
}
