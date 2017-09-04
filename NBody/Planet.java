public class Planet {
	public Planet(double xP, double yP, double xV, 
		      double yV, double m, String img) {
		this.xP = xP;
		this.yP = yP;
		this.xV = xV;
		this.yV = yP;
		this.m = m;
		this.img = img;
	}
	public Planet(Planet p){
		this.xP = p.xP;
                this.yP = p.yP;
                this.xV = p.xV;
                this.yV = p.yP;
                this.m = p.m;
                this.img = p.img;

	}
}
