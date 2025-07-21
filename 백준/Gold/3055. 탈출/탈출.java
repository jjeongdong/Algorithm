import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        Queue<Point> bQueue = new LinkedList<>();
        Queue<Point> wQueue = new LinkedList<>();
        boolean[][] bVisited = new boolean[N][M];
        boolean[][] wVisited = new boolean[N][M];
        boolean flag = false;
        int cnt = 0;
        int limit = N * M;
        int L = 0;

        // 비버 & 물 초기화
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);

                if (board[i][j] == 'S') {
                    bQueue.add(new Point(i, j));
                    bVisited[i][j] = true;
                } else if (board[i][j] == '*') {
                    wQueue.add(new Point(i, j));
                    wVisited[i][j] = true;
                }
            }
        }

        while (cnt++ < limit) {
            // 물의 움직임
            int wLen = wQueue.size();
            for (int i = 0; i < wLen; i++) {
                Point now = wQueue.poll();
                int x = now.x;
                int y = now.y;
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if (!wVisited[nx][ny] && board[nx][ny] != 'X' && board[nx][ny] != 'D') {
                            board[nx][ny] = '*';
                            wVisited[nx][ny] = true;
                            wQueue.add(new Point(nx, ny));
                        }
                    }
                }
            }

            // 비버의 움직임
            int bLen = bQueue.size();
            for (int i = 0; i < bLen; i++) {
                Point now = bQueue.poll();
                int x = now.x;
                int y = now.y;
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if (board[nx][ny] == 'D') {
                            flag = true;
                            break;
                        }
                        if (!bVisited[nx][ny] && board[nx][ny] != 'X' && board[nx][ny] != '*') {
                            board[nx][ny] = 'S';
                            bVisited[nx][ny] = true;
                            bQueue.add(new Point(nx, ny));
                        }
                    }
                }
                if (flag) break;
            }
            if (flag) break;
            else L++;
        }

        if (flag)  System.out.println(L + 1);
        else System.out.println("KAKTUS");
    }

    static class Point {
        int x;
        int y;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
