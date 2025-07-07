import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        ArrayList<Edge> A = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            A.add(new Edge(start, end, weight));
        }

        for (int i = 1; i < N; i++) {
            for (Edge e : A) {
                if (dist[e.start] != Integer.MAX_VALUE && dist[e.end] > dist[e.start] + e.weight) {
                    dist[e.end] = dist[e.start] + e.weight;
                }
            }
        }

        boolean cycle = false;
        for (Edge e : A) {
            if (dist[e.start] != Integer.MAX_VALUE && dist[e.end] > dist[e.start] + e.weight) {
                dist[e.end] = dist[e.start] + e.weight;
                cycle = true;
            }
        }

        if (cycle) {
            sb.append(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == Integer.MAX_VALUE) sb.append(-1).append("\n");
                else sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
