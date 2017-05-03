package covering_segments;

import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
    	int max = Integer.MAX_VALUE;
    	int min_end = 0;
        int[] points = new int[2 * segments.length];
        for (int i = 0; i < segments.length; i++) {
        	//find minimum of Segments end
        	for (int j=0; j<segments.length; j++)
        		if(segments[min_end].end > segments[j].end)
        			min_end = j;
        	
        	for (int k=0; k<segments.length; k++)
        		if(segments[k].start <= segments[min_end].end && 
        				segments[k].end > segments[min_end].end) {
        			segments[k].end = max;
        			i++;
        		}
        	
        	
            points[i] = segments[min_end].end;
            segments[min_end].end = max;
        }
        return points;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
