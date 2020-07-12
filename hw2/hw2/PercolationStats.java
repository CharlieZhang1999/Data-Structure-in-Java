package hw2;
import java.lang.Math;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;
public class PercolationStats {
    private Percolation perc;
    private final int t; //number of trials
    private double threshold;
    private double data [];

    public PercolationStats(int N, int T, PercolationFactory pf){
        if(N <= 0 || T <= 0){
            throw new IllegalArgumentException("the grid size and the number of experiments should be both greather than zero");
        }
        t = T;
        data = new double[T];
        for(int i = 0; i < T; i++){
            perc = pf.make(N);
            while(!perc.percolates()){
                int r = StdRandom.uniform(0, N);
                int c = StdRandom.uniform(0, N);
                if(!perc.isOpen(r, c)){
                    perc.open(r, c);
                }
            }
            threshold = (double) perc.numberOfOpenSites() / (double) (N * N);
            data[i] = threshold;
        }

    }   // perform T independent experiments on an N-by-N grid
    public double mean(){ // sample mean of percolation threshold
        return StdStats.mean(data);
    }
    public double stddev(){ // sample standard deviation of percolation threshold
        return StdStats.stddev(data);
    }
    public double confidenceLow(){
        return mean() - 1.96 * stddev() / Math.sqrt(t);
    }                                  // low endpoint of 95% confidence interval
    public double confidenceHigh(){
        return mean() + 1.96 * stddev() / Math.sqrt(t);
    }                              // high endpoint of 95% confidence interval


    public static void main(String[] args){
        PercolationFactory pf = new PercolationFactory();
        PercolationStats ps = new PercolationStats(10, 30, pf);
        System.out.println(ps.mean());
    }
}
