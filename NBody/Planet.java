public class Planet {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;

    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        // Distances and mass are in meters and kilograms, respectively.
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

// Makes a copy of the passed in object (copies the values of all the fields into a new object)
    public Planet(Planet planet) {
        this.xxPos = planet.xxPos;
        this.yyPos = planet.yyPos;
        this.xxVel = planet.xxVel;
        this.yyVel = planet.yyVel;
        this.mass = planet.mass;
        this.imgFileName = planet.imgFileName;
    }

    public double calcDistance(Planet otherPlanet) {
        double deltaX, deltaX_squared, deltaY, deltaY_squared, r_squared, r;
        deltaX = this.xxPos - otherPlanet.xxPos; 
        deltaX_squared = deltaX*deltaX;
        deltaY = this.yyPos - otherPlanet.yyPos;
        deltaY_squared = deltaY*deltaY;

        r_squared = deltaX_squared + deltaY_squared;
        r = Math.sqrt(r_squared);
        return r;
        @TODO: Make the method return a value that's capped @ 2 dec places
    }

    public static void main(String[] args) {
        Planet Saturn = new Planet(2.3e12, 9.5e11, 0, 0, 6.0e26, "");
        Planet Sun = new Planet(1.0e12, 2.0e11, 0, 0, 2.0e30, "");

        System.out.println(Saturn.calcDistance(Sun));
    }
}
