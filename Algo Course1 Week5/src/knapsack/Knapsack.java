package knapsack;

import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        int[][] value = new int[W+1][w.length+1];
        for(int i=1; i<=w.length; i++) {
        	for(int v=1; v<=W; v++){
        		value[v][i] = value[v][i-1];
        		if(w[i-1] <= v) {
        			int val = value[v-w[i-1]][i-1] + w[i-1];
        			if(value[v][i] < val)
        				value[v][i] = val;
        		}
        	}
        }
        
        return value[W][w.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

