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
    static int[][] arr;
    static int depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        queue = new LinkedList<>();
        arr = new int[N + 1][2];
        depth = 1;

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

        arr[1][0] = 0;
        arr[1][1] = 1;
        BFS(1);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCS(a, b)).append("\n");
        }

        System.out.println(sb);
    }

    private static void BFS(int num) {
        queue.add(num);
        visited[num] = true;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int now = queue.poll();
                for (int tmp : tree[now]) {
                    if (!visited[tmp]) {
                        arr[tmp][0] = now;
                        arr[tmp][1] = depth + 1;
                        queue.add(tmp);
                        visited[tmp] = true;
                    }
                }

            }
            depth++;
        }
    }

    private static int LCS(int a, int b) {
        if (arr[a][1] < arr[b][1]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        // 깊이 맞추기
        while (arr[a][1] != arr[b][1]) {
            a = arr[a][0];
        }

        // 같은 조상이 나올떄까지 함꼐 올라가기
        while (a != b) {
            a = arr[a][0];
            b = arr[b][0];
        }

        return a;
    }
}
