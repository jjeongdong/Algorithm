import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] A;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        int answer = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int sum = bfs(i);
            if (sum < min) {
                min = sum;
                answer = i;
            }
        }

        System.out.println(answer);
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : A[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                    queue.offer(next);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += dist[i];
        }

        return sum;
    }
}
