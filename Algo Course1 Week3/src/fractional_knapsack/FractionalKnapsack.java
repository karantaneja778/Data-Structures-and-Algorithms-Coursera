package fractional_knapsack;

import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        int n = values.length;
        
        for(int i=0; i<n; i++) {
        	if(capacity == 0)
        		return value;
        	
        	int max = 0;
        	
        	for(int j=0; j<n; j++) {
        		if (weights[j] > 0) {
        			if (((double)values[max]*1.0)/((double)weights[max]*1.0) < ((double)values[j]*1.0)/((double)weights[j]*1.0))
        				max = j;
        		}
        	}
        	
        	int a = 0;
        	if(weights[max] < capacity)
        		a = weights[max];
        	else
        		a = capacity;
        	
        	value = value + a*((double)values[max]*1.0)/((double)weights[max]*1.0);
        	
        	weights[max] = weights[max] - a;
        	capacity = capacity -a;
        	
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
