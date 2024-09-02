import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int C;
    static int count = 0;
    static int[][] board;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = board[y][x] = 1;
        }

        T.DFS(1);
        System.out.println(count);
    }

    public void DFS(int L) {
        visit[L] = true;

        for (int j = 1; j <= N; j++) {
            if (board[L][j] == 1 && !visit[j]) {
                count++;
                DFS(j);
            }
        }
    }
}
