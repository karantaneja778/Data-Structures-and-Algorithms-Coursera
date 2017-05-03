package dot_product;

import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
        //write your code here
        long result = 0;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
        	int first =0;
        	int second = 0;
        	for (int j=0; j< a.length; j++)
        		if(a[first]<a[j])
        			first = j;
        	for (int k=0; k<b.length; k++)
        		if(b[second] < b[k])
        			second = k;
        	
            result += (long)a[first] * (long)b[second];
            a[first] = min;
            b[second] = min;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

