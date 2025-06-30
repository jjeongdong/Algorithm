

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] board;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        bfs();
        System.out.println(dist[N - 1][M - 1]);
    }

    private static void bfs() {
        visited[0][0] = true;
        dist[0][0] = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nx = now.getX();
            int ny = now.getY();

            for (int i = 0; i < 4; i++) {
                int x = nx + dx[i];
                int y = ny + dy[i];
                if (x < N && x >= 0 && y < M && y >= 0) {
                    if (board[x][y] == 1 && !visited[x][y]) {
                        visited[x][y] = true;
                        dist[x][y] = dist[nx][ny] + 1;
                        queue.offer(new Point(x, y));
                    }
                }
            }
        }
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
