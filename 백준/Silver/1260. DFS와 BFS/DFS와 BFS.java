import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] visited;
    static int N, M, V;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arr.get(i));
        }

        dfs(V);
        sb.append("\n");
        bfs(V);
    }

    public static void dfs(int start) {
        sb.append(start).append(" ");
        visited[start] = true;

        for (int i = 0; i < arr.get(start).size(); i++) {
            int y = arr.get(start).get(i);
            if (!visited[y]) {
                dfs(y);
            }
        }
    }

    public static void bfs(int start) {
        visited = new boolean[N + 1];
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int next = queue.poll();
                sb.append(next).append(" ");

                for (int j = 0; j < arr.get(next).size(); j++) {
                    int y = arr.get(next).get(j);
                    if (!visited[y]) {
                        queue.add(y);
                        visited[y] = true;
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
