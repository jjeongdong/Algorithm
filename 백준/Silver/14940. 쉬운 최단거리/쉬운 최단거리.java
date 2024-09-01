import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean flag;
    static int L = 0;
    static int gx, gy;
    static int N, M;
    static int[][] board;
    static int[][] answer;
    static boolean[][] visit;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Point> Q = new LinkedList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[N][M];
        board = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer[i][j] = -1;
            }
        }


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 2) {
                    gx = i;
                    gy = j;
                } else if (tmp == 0) {
                    answer[i][j] = 0;
                }

                board[i][j] = tmp;
            }
        }

        Q.add(new Point(gx, gy));
        visit[gx][gy] = true;
        answer[gx][gy] = 0;

        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Point point = Q.poll();

                if (board[point.x][point.y] == 1) {
                    answer[point.x][point.y] = L;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = point.x + dx[j];
                    int ny = point.y + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        if (!visit[nx][ny] && board[nx][ny] == 1) {
                            visit[nx][ny] = true;
                            Q.add(new Point(nx, ny));
                        }
                    }
                }
            }

            L++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
