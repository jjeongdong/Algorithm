import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int[][] arr;
    static boolean[] visit;
    static int N, M, V;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }

        // DFS
        T.DFS(V);
        Arrays.fill(visit, false);

        // BFS
        queue.add(V);
        visit[V] = true;
        sb.append("\n").append(V).append(" ");

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (arr[idx][i] == 1 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }

        System.out.println(sb);
    }

    private void DFS(int L) {
        sb.append(L).append(" ");
        visit[L] = true;
        for (int i = 1; i <= N; i++) {
            if (arr[L][i] == 1 && !visit[i]) {
                DFS(i);
            }
        }
    }
}
