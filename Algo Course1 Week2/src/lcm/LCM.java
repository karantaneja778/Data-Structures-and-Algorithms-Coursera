package lcm;

import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }
  
  private static int gcd_fast(int a, int b) {	  
	  if(a%b == 0)
		  return b;
	  
	  return gcd_fast(b, a%b);
  }
  
  private static long lcm_fast(int a, int b) {
	  long product = (long)a * b;
	  int gcd = gcd_fast(a, b);
	  long lcm = (long)product/gcd;
	  return lcm;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_fast(a, b));
  }
}
