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

    public Planet(Planet planet) {
        planet.xxPos = xxPos;
        planet.yyPos = yyPos;
        planet.xxVel = xxVel;
        planet.yyVel = yyVel;
        planet.mass = mass;
        planet.imgFileName = imgFileName;
    }

}
