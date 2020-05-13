public class NBody {
	//public final class In extends Object;
	//public int num_of_planets;
	public static String starfieldimg = "images/starfield.jpg";
	public static double readRadius(String filepath) {
		In in = new In(filepath);
		int num_of_planets = in.readInt();
		double radius = in.readDouble();
		return radius;	
	}
	public static Planet[] readPlanets(String filepath) {
		In in = new In(filepath);
		int num_of_planets = in.readInt();
		double radius = in.readDouble();
		Planet p [] = new Planet[num_of_planets];
		for(int i = 0; i < num_of_planets; i++) {
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double  m = in.readDouble();
			String img = in.readString();
			p[i] = new Planet(xP, yP, xV, yV, m, img);
			
		}
		return p;
	}
	public static void main(String[] args) {
		/**initialization*/
		double T = Double.parseDouble(args[0]);
		double dT = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = NBody.readRadius(filename);
		Planet p [] = NBody.readPlanets(filename);
		
		/**initialize xForces and yForces array*/
		double [] xForces = new double[p.length];
		double [] yForces = new double[p.length];
		
		/**set time variable to 0*/
		double tracking_time = 0;
		

		/**enable Double Buffering*/
		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, starfieldimg);
		
		StdDraw.show();
		StdDraw.pause(2000);	
		
		for(int i = 0; i < p.length; i++) {
			p[i].draw();
		}
		
		/**start the loop to draw the universe dynamically*/
		while(tracking_time < T) {
			/**fill in xForces and yForces*/
			for(int i = 0; i < p.length; i++) {
				xForces[i] = p[i].calcNetForceExertedByX(p);
				yForces[i] = p[i].calcNetForceExertedByY(p);
				
			}
			
			/**after the entire forces arrays are done, do the update*/
			for(int i = 0; i < p.length; i++) {
				p[i].update(dT, xForces[i], yForces[i]);
			}
			/**Draw the background image*/
			StdDraw.picture(0, 0, starfieldimg);
			
			/**Draw all of the planets.*/
			for(int i = 0; i < p.length; i++) {
				p[i].draw();
			}
			
			StdDraw.show();
			StdDraw.pause(10);	
			
			tracking_time = tracking_time + dT;
		}
		
		StdOut.printf("%d\n", p.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < p.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  p[i].xxPos, p[i].yyPos, p[i].xxVel,
		                  p[i].yyVel, p[i].mass, p[i].imgFileName);   
		}
		
	}
}
