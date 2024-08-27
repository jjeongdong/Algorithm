import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] board;
    static boolean[][] visit;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        int max = Integer.MIN_VALUE;
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num > max) {
                    max = num;
                }

                board[i][j] = num;
            }
        }

        for (int n = 0; n < max; n++) {
            visit = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j] && board[i][j] > n) {
                        cnt++;
                        T.DFS(i, j, n);
                    }
                }
            }

            if (answer < cnt) {
                answer = cnt;
            }
        }

        System.out.println(answer);
    }

    private void DFS(int x, int y, int n) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visit[nx][ny] && board[nx][ny] > n) {
                    DFS(nx, ny, n);
                }
            }
        }
    }
}
