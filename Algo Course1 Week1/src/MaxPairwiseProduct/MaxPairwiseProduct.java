package MaxPairwiseProduct;

import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (((long)numbers[i]) * numbers[j] > result) {
                    result = ((long)numbers[i]) * numbers[j];
                }
            }
        }
        return result;
    }
    
    static long getMaxPairwisePorductFast(int[] numbers) {
		int n = numbers.length;
		int max_index1 = -1;
		for(int i=0; i<n; i++) {
			if((max_index1 == -1) || (numbers[i] > numbers[max_index1]))
				max_index1 = i;
		}
		
		int max_index2 = -1;
		for(int i=0; i<n; i++) {
			if((i != max_index1) && ((max_index2 == -1) || (numbers[i] > numbers[max_index2])))
				max_index2 = i;
		}
		
		return ((long)numbers[max_index1]) * numbers[max_index2];
    }
    

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        
       System.out.println(getMaxPairwisePorductFast(numbers));
       
    }
        
       /*while(true) {
        	Random rand = new Random();
        	int n = rand.nextInt(3)+2;
        	System.out.println("n is " + n);
        	int[] numbers = new int[n];
        	for (int i=0; i<n; i++){
        		numbers[i] = rand.nextInt(1000);
        		System.out.print(numbers[i] + " ");
        	}
        	long res1 = getMaxPairwisePorductFast(numbers);
        	long res2 = getMaxPairwiseProduct(numbers);
        	if(res1 != res2) {
        		System.out.println(res1 + " ! = " + res2);
        		break;
        	}
        	else {
        		System.out.println("OK");
        	}
        		
        	}
        }
    */

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}