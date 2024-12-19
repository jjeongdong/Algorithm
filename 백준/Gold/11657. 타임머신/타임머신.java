import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 도시의 개수
        int M = Integer.parseInt(st.nextToken());   // 버스 노선의 개수
        long[] distance = new long[N + 1];
        ArrayList<Edge> graph = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.add(new Edge(startNode, endNode, weight));
        }

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        // 벨만-포드 알고리즘: Relaxation 단계
        for (int i = 0; i < N - 1; i++) {
            for (Edge edge : graph) {
                if (distance[edge.start] != Integer.MAX_VALUE) {
                    distance[edge.end] = Math.min(distance[edge.end], distance[edge.start] + edge.weight);
                }
            }
        }

        // 음수 사이클 검출
        boolean hasNegativeCycle = false;
        for (Edge edge : graph) {
            if (distance[edge.start] != Integer.MAX_VALUE &&
                    distance[edge.end] > distance[edge.start] + edge.weight) {
                hasNegativeCycle = true;
                break;
            }
        }

        if (hasNegativeCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(distance[i]);
                }
            }
        }
    }
}

class Edge {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
