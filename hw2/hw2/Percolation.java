package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import static org.junit.Assert.*;
public class Percolation {
    private int gridsize;
    private int num_opensites;
    private WeightedQuickUnionUF uf;
    private boolean openslots[][];

    public Percolation(int N){// create N-by-N grid, with all sites initially blocked
        if(N < 0){
            throw new java.lang.IllegalArgumentException("Grid size should be greater than 0");
        }
        this.uf = new WeightedQuickUnionUF(N*N + 2);//let the N*N be the top node, so whenever we have a full site on the top, we union this site to the top node; let the N*N + 1 be the representative of the bottom node
        openslots = new boolean[N][N];
        gridsize = N;
        num_opensites = 0;
    }

    public void open(int row, int col){// open the site (row, col) if it is not open already
        if(row < 0 || row > gridsize - 1 || col < 0 || col > gridsize - 1){
            throw new java.lang.IndexOutOfBoundsException("Index out of bound");
        }
        if(openslots[row][col]){
            return;
        }
        openslots[row][col] = true;
        if(row == 0){
            this.uf.union(to1D(row, col), gridsize * gridsize); // we union this site to the representative of the top node, which is at the N * N slot
        }

        if(row == gridsize - 1){
            this.uf.union(to1D(row, col), gridsize * gridsize + 1);// we union this site to the representative of the bottom node, which is at the N * N + 1 slot
        }
        if(row > 0 && openslots[row - 1][col]){
            this.uf.union(to1D(row, col), to1D(row - 1, col));
        }
        if(row < gridsize - 1 && openslots[row + 1][col]){
            this.uf.union(to1D(row, col), to1D(row + 1, col));
        }
        if(col > 1 && openslots[row][col - 1]){
            this.uf.union(to1D(row, col), to1D(row, col - 1));
        }
        if(col < gridsize - 1 && openslots[row][col + 1]){
            this.uf.union(to1D(row, col), to1D(row, col + 1));
        }
        num_opensites += 1;
    }
    
    private int to1D(int row, int col){
        return gridsize * row + col;
    }

    public boolean isOpen(int row, int col){// is the site (row, col) open?
        return openslots[row][col];
    }
    public boolean isFull(int row, int col){// is the site (row, col) full?
        int tranformed_to_1d = to1D(row, col);
        if(uf.connected(gridsize * gridsize, tranformed_to_1d)){//if it's connected with the top node, it's full
            return true;
        }
        return false;


    }


    public int numberOfOpenSites(){// number of open sites
        return num_opensites;
    }
    public boolean percolates(){// does the system percolate?
        if(uf.connected(gridsize * gridsize, gridsize * gridsize + 1)){//if the top node is connected with the bottom node, it percolates
            return true;
        }
        return false;

    }
    /*public static void main(String[] args){

        Percolation pc = new Percolation(5);
        pc.open(0, 1);
        pc.open(1, 1);
        pc.open(1, 0);
        pc.open(1, 0);
        assertTrue(pc.isFull(1, 0));
        System.out.println(pc.percolates());
        System.out.println(pc.numberOfOpenSites());
    }   // use for unit testing (not required)*/
}
