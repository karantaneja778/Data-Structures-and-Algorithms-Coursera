package change;

import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
    	int tens = m/10;
    	int fives = (m%10)/5;
    	int ones = (m%10)%5;
        return tens + fives + ones;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

