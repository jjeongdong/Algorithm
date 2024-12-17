import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] board;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        Queue<Brick> queue = new LinkedList<>();
        queue.add(new Brick(0, 0, false, 1));

        int answer = BFS(queue, N, M);
        System.out.println(answer);
    }

    private static int BFS(Queue<Brick> queue, int N, int M) {
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Brick now = queue.poll();
                int x = now.x;
                int y = now.y;
                if (x == N - 1 && y == M - 1) {
                    return now.cnt;
                }
                for (int j = 0; j < 4; j++) {
                    int xx = x + dx[j];
                    int yy = y + dy[j];

                    if (xx >= 0 && xx < N && yy >= 0 && yy < M) {
                        if (board[xx][yy] == 0) {       // 벽이 아닐 경우
                            if (!now.destroyed && !visited[xx][yy][0]) {    // 벽을 부수지 않았을 경우
                                queue.add(new Brick(xx, yy, false, now.cnt + 1));
                                visited[xx][yy][0] = true;
                            } else if (now.destroyed && !visited[xx][yy][1]) {  // 벽을 부쉈을 경우
                                queue.add(new Brick(xx, yy, true, now.cnt + 1));
                                visited[xx][yy][1] = true;
                            }
                        } else if (board[xx][yy] == 1) {    // 벽일 경우
                            if (!now.destroyed) {
                                queue.add(new Brick(xx, yy, true, now.cnt + 1));
                                visited[xx][yy][1] = true;
                            }
                        }
                    }

                }
            }
        }

        return -1;
    }
}

class Brick {
    int x;
    int y;
    boolean destroyed;
    int cnt;

    public Brick(int x, int y, boolean destroyed, int cnt) {
        this.x = x;
        this.y = y;
        this.destroyed = destroyed;
        this.cnt = cnt;
    }
}
