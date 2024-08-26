import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M, N, K;
    static int[][] board;
    static boolean[][] visit;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        int x, y, answer;

        for (int i = 0; i < tc; i++) {
            answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            board = new int[M][N];
            visit = new boolean[M][N];

            K = Integer.parseInt(st.nextToken());

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                board[x][y] = 1;
            }

            for (int k = 0; k < M; k++) {
                for (int l = 0; l < N; l++) {
                    if (board[k][l] == 1 && !visit[k][l]) {
                        T.DFS(k, l);
                        answer++;
                    }
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    public void DFS(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (!visit[nx][ny] && board[nx][ny] == 1) {
                    DFS(nx, ny);
                }
            }
        }
    }
}
