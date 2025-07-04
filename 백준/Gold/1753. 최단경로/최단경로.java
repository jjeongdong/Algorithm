import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[V + 1];
        int[] dist = new int[V + 1];

        for (int i = 0; i < V + 1; i++) {
            if (i == K) {
                dist[i] = 0;
            } else {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        ArrayList<Node>[] A = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            A[start].add(new Node(end, weight));
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(K, 0));

        while (!priorityQueue.isEmpty()) {
            Node now = priorityQueue.poll();
            if (visited[now.end]) continue;
            visited[now.end] = true;

            for (Node node : A[now.end]) {
                if (dist[node.end] > dist[now.end] + node.weight) {
                    dist[node.end] = dist[now.end] + node.weight;
                    priorityQueue.add(new Node(node.end, dist[node.end]));
                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
