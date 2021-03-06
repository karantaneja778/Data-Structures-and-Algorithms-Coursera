package fibonacci;

import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }
  
  private static long calc_fib_fast(int n) {
	  if(n == 0)
		  return 0;
	  if(n == 1)
		  return 1;
	  
	  long[] f = new long[n+1];
	  f[0] = 0;
	  f[1] = 1;
	  for(int i = 2; i<=n; i++) {
		  f[i] = f[i-1] + f[i-2]; 
	  }
	  return f[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib_fast(n));
  }
}
