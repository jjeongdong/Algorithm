import java.util.*;

class Solution {
    private static class Point {
        long x;
        long y;

        public Point (long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public String[] solution(int[][] line) {
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i; j < line.length; j++) {
                Point point = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                    
                if (point != null) {
                    pointList.add(point);
                } 
            }
        }
        
        Point minPoint = getMinimumPoint(pointList);
        Point maxPoint = getMaximumPoint(pointList);
        
        int width = (int) (maxPoint.x - minPoint.x + 1);
        int height = (int) (maxPoint.y - minPoint.y + 1);
        
        char[][] arr = new char[height][width];
        for(char[] row : arr) {
            Arrays.fill(row, '.');
        }
        
        for (Point p : pointList) {
            int x = (int) (p.x - minPoint.x);
            int y = (int) (maxPoint.y - p.y);
            
            arr[y][x] = '*';
        }
        
        String[] answer = new String[arr.length];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = new String(arr[i]);
        }
        return answer;
    }
    
    private Point getMinimumPoint(List<Point> pointList) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for (Point p : pointList) {
            if (x > p.x) x = p.x;
            if (y > p.y) y = p.y;
        }
        
        return new Point(x, y);
    }
    
    private Point getMaximumPoint(List<Point> pointList) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for (Point p : pointList) {
            if (x < p.x) x = p.x;
            if (y < p.y) y = p.y;
        }
        
        return new Point(x, y);
    }
    
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - c1 * b2) / (a1 * b2 - b1 * a2);
        double y = (double) (c1 * a2 - a1 * c2) / (a1 * b2 - b1 * a2);
        
        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }
        
        return new Point((long) x, (long) y);
    }
}