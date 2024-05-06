import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Point> Q = new LinkedList<>();
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int L = 0;
        boolean flag = false;

        int[][] board = new int[n + 1][m + 1];
        board[1][1] = 0;

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(str.charAt(j - 1)));
            }
        }

        Q.offer(new Point(1, 1));

        while (!Q.isEmpty()) {

            if (flag) break;
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Point tmp = Q.poll();

                if (tmp.x == n && tmp.y == m) {
                    flag = true;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    if (nx >= 1 && nx <= n && ny >= 1 && ny <= m && board[nx][ny] == 1) {
                        Q.offer(new Point(nx, ny));
                        board[nx][ny] = 0;
                    }
                }
            }
            L++;
        }


        System.out.println(L);

    }
}
