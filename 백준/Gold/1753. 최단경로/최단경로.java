import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());    // 시작 번호

        int[] arr = new int[V + 1];
        for (int i = 1; i < arr.length; i++) {
            if (i == K) arr[i] = 0;
            else arr[i] = Integer.MAX_VALUE;
        }

        boolean[] visited = new boolean[V + 1];
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

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.end]) continue;
            visited[now.end] = true;

            for (Node node : A[now.end]) {
                if (arr[node.end] > arr[now.end] + node.weight) {
                    arr[node.end] = arr[now.end] + node.weight;
                    pq.offer(new Node(node.end, arr[node.end]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (arr[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(arr[i]).append("\n");
            }
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
