package hw2;
import java.lang.Math;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;
public class PercolationStats {
    private Percolation perc;
    private int r,c,t;
    private double threshold;
    private double data [];
    private double mean, std;

    public PercolationStats(int N, int T, PercolationFactory pf){
        if(N <= 0 || T <= 0){
            throw new IllegalArgumentException("the grid size and the number of experiments should be both greather than zero");
        }
        t = T;
        data = new double[T];
        for(int i = 0; i < T; i++){
            perc = pf.make(N);
            while(!perc.percolates()){
                r = StdRandom.uniform(0, N);
                c = StdRandom.uniform(0, N);
                if(!perc.isOpen(r, c)){
                    perc.open(r, c);
                }
            }
            threshold = (double) perc.numberOfOpenSites() / (double) (N * N);
            data[i] = threshold;
        }

    }   // perform T independent experiments on an N-by-N grid
    public double mean(){ // sample mean of percolation threshold
        mean = StdStats.mean(data);
        return mean;
    }
    public double stddev(){ // sample standard deviation of percolation threshold
        std = StdStats.stddev(data);
        return std;
    }
    public double confidenceLow(){
        return mean - 1.96 * std / Math.sqrt(t);
    }                                  // low endpoint of 95% confidence interval
    public double confidenceHigh(){
        return mean + 1.96 * std / Math.sqrt(t);
    }                              // high endpoint of 95% confidence interval


    /*public static void main(String[] args){
        PercolationFactory pf = new PercolationFactory();
        PercolationStats ps = new PercolationStats(10, 30, pf);
        System.out.println(ps.mean());
    }*/
}
