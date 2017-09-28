public class Planet {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;

    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
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

    public calcDistance(Planet otherPlanet) {
        double deltaX = this.xxPos - otherPlanet.xxPos; 
        deltaX_squared = deltaX*deltaX;
        double deltaY = this.yyPos - otherPlanet.yyPos;
        deltaY_squared = deltaY*deltaY;

        double r_squared = deltaX_squared + deltaY_squared;
        return Math.sqrt(r_squared);
    }

    public static void main(String[] args) {
        Planet Saturn = new Planet()
    }
}
