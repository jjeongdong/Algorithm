import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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


        Queue<Point> Q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st1.nextToken());
        int x = Integer.parseInt(st1.nextToken());

        int[][] board = new int[x][y];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int L = 0;

        for (int i = 0; i < x; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                int tmp = Integer.parseInt(st2.nextToken());
                board[i][j] = tmp;
                if (tmp == 1) {
                    Q.offer(new Point(i, j));
                }
            }
        }

        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Point point = Q.poll();
                for (int j = 0; j < 4; j++) {
                    int dsx = point.x + dx[j];
                    int dsy = point.y + dy[j];
                    if (dsx >= 0 && dsx < x && dsy >= 0 && dsy < y) {
                        if (board[dsx][dsy] == 0) {
                            board[dsx][dsy] = 1;
                            Q.offer(new Point(dsx, dsy));
                        }
                    }
                }
            }

            L++;
        }

        int cnt = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 1 || board[i][j] == -1) {
                    cnt++;
                }
            }
        }

        if (cnt == x * y) {
            System.out.println(L - 1);
        } else {
            System.out.println(-1);
        }


    }
}
