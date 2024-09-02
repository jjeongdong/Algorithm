import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int N, M;
    static int[][] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                T.DFS(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private void DFS(int L) {
        if (visit[L]) {
            return;
        }

        visit[L] = true;
        for (int i = 1; i <= N; i++) {
            if (arr[L][i] == 1) {
                DFS(i);
            }
        }
    }
}
