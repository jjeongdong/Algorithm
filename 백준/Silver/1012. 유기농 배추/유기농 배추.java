import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M, N, K;
    static int count;
    static boolean[][] visit;
    static int[][] cabbage;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            count = 0;
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st1.nextToken());
            N = Integer.parseInt(st1.nextToken());

            visit = new boolean[M][N];
            cabbage = new int[M][N];

            K = Integer.parseInt(st1.nextToken());

            for (int j = 0; j < K; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());

                cabbage[x][y] = 1;
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (cabbage[x][y] == 1 && !visit[x][y]) {
                        T.DFS(x, y);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public void DFS(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N ) {
                if (!visit[nx][ny] && cabbage[nx][ny] == 1) {
                    DFS(nx, ny);
                }
            }
        }
    }
}
