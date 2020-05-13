import java.lang.Math; 
public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double G = 6.67e-11;
	public static final String truepath = "images/";
	
	
	public Planet(double xP, double yP, double xV,
            double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
				
	}
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
		
	}

	public double calcDistance(Planet p) {
		double dx = p.xxPos - xxPos;
		double dy = p.yyPos - yyPos;
		double distance = Math.sqrt(dx * dx + dy * dy);
		return distance;
	}
	public double calcForceExertedBy(Planet p) {
		double r = calcDistance(p);
		double F = mass * p.mass * G / (r * r);
		return F;
	}
	public double calcForceExertedByX(Planet p) {
		double F = calcForceExertedBy(p);
		double dx = p.xxPos - xxPos;
		//double dy = p.yyPos - yyPos;
		double r = calcDistance(p);
		double F_x = F * dx / r;
		return F_x;
	}
	public double calcForceExertedByY(Planet p) {
		double F = calcForceExertedBy(p);
		//double dx = p.xxPos - xxPos;
		double dy = p.yyPos - yyPos;
		double r = calcDistance(p);
		double F_y = F * dy / r;
		return F_y;
	}
	
	
	public double calcNetForceExertedByX(Planet p[]) {
		double netF_x = 0;
		for(int i = 0;i < p.length; i++) {
			if(this.equals(p[i])) {
				continue;
			}
			else {
				netF_x = netF_x + calcForceExertedByX(p[i]);
			}
		}
		return netF_x;
	}
	public double calcNetForceExertedByY(Planet p[]) {
		double netF_y = 0;
		for(int i = 0;i < p.length; i++) {
			if(this.equals(p[i])) {
				continue;
			}
			else {
			netF_y = netF_y + calcForceExertedByY(p[i]);
			}
		}
		return netF_y;
	}
	
	public void update(double time, double NetForceExertedByX, double NetForceExertedByY) {
		double a_x = NetForceExertedByX / mass;
		double a_y = NetForceExertedByY / mass;
		xxVel = xxVel + a_x * time;
		yyVel = yyVel + a_y * time;
		xxPos = xxPos + xxVel * time;
		yyPos = yyPos + yyVel * time;
		
	}
	public void draw() {
		String temp_imgFileName = truepath + imgFileName;
		StdDraw.enableDoubleBuffering();
		StdDraw.picture(xxPos, yyPos, temp_imgFileName);
		StdDraw.show();
	}
}
