package hw2;
import edu.princeton.cs.introcs.StdRandom;
public class PercolationFactory {
    public Percolation make(int N) {
        return new Percolation(N);
    }
}
