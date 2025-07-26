import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int E;
    static boolean flag = false;
    static int[] dist;
    static ArrayList<Edge>[] A;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        answer = 0;

        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            A[start].add(new Edge(end, weight));
            A[end].add(new Edge(start, weight));
        }

        int tmp = 0;
        flag = false;
        st = new StringTokenizer(br.readLine());
        int V1 = Integer.parseInt(st.nextToken());
        int V2 = Integer.parseInt(st.nextToken());

        if (!flag) dijkstra(1, V1);
        if (!flag) dijkstra(V1, V2);
        if (!flag) dijkstra(V2, N);

        tmp = answer;
        answer = 0;

        if (!flag) dijkstra(1, V2);
        if (!flag) dijkstra(V2, V1);
        if (!flag) dijkstra(V1, N);

        System.out.println(Math.min(answer, tmp));
    }

    public static void dijkstra(int start, int idx) {
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            for (Edge edge : A[now.end]) {
                if (dist[edge.end] > dist[now.end] + edge.weight) {
                    dist[edge.end] = dist[now.end] + edge.weight;
                    pq.add(new Edge(edge.end, dist[edge.end]));
                }
            }
        }

        if (dist[idx] == Integer.MAX_VALUE) {
            answer = -1;
            flag = true;
            return;
        }

        answer += dist[idx];
    }

    private static void printArr() {
        for (int i = 1; i <= N; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    static class Edge implements Comparable<Edge> {
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
