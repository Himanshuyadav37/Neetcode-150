// import java.util.*;

class Solution {

    static class Point {
        int x;
        int y;
        int distSq;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distSq = x * x + y * y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        // Min Heap: smallest distance first
        PriorityQueue<Point> pq = new PriorityQueue<>(
            (p1, p2) -> p1.distSq - p2.distSq
        );

        // Add all points
        for (int[] point : points) {
            pq.add(new Point(point[0], point[1]));
        }

        // Store answer
        int[][] ans = new int[k][2];

        // Take K nearest points
        for (int i = 0; i < k; i++) {
            Point p = pq.poll();

            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }

        return ans;
    }
}