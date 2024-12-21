import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static Queue<Integer> queue;
    static int[] depth;
    static int[][] parent;
    static int L;
    static int kmax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        queue = new LinkedList<>();
        depth = new int[N + 1];
        parent = new int[21][100001];

        L = 1;

        int tmp = 1;
        kmax = -1;
        while (tmp <= N) {
            tmp <<=  1;
            kmax++;
        }

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            tree[start].add(end);
            tree[end].add(start);
        }

        parent[0][1] = 0;
        depth[1] = 1;
        BFS(1);

        for (int k = 1; k <= kmax; k++) {
            for (int n = 1; n <= N; n++) {
                parent[k][n] = parent[k - 1][parent[k - 1][n]];
            }
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int LCA = excuteLCA(a, b);
            sb.append(LCA).append("\n");
        }

        System.out.println(sb);
    }

    private static int excuteLCA(int a, int b) {
        if (depth[a] > depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        // 깊이 맞추기
        for (int k = kmax; k >= 0; k--) {
            if (Math.pow(2, k) <= depth[b] - depth[a]) {
                b = parent[k][b];
            }
        }

        // 동시에 올라가면서 조상 찾기
        for (int k = kmax; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        int LCA = a;
        if (a != b) {
            LCA = parent[0][LCA];
        }
        return LCA;
    }

    private static void BFS(int node) {
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int now = queue.poll();
                for (int next : tree[now]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                        parent[0][next] = now;
                        depth[next] = L + 1;
                    }
                }
            }
            L++;
        }
    }
}
