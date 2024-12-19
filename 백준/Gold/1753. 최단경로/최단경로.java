import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 5 6
 * 1
 * 5 1 1
 * 1 2 2
 * 1 3 3
 * 2 3 4
 * 2 4 5
 * 3 4 6
 */
public class Main {
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Node>[] graph;
    static int V;
    static int E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());   // 정점의 개수
        E = Integer.parseInt(st.nextToken());   // 간선의 개수
        int startNode = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
        }

        distance = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            if (i == startNode) {
                distance[i] = 0;
            } else {
                distance[i] = Integer.MAX_VALUE;
            }
        }
        visited = new boolean[V + 1];

        for (int i = 0; i < V; i++) {
            int minValue = findMinValue();
            visited[minValue] = true;
            for (Node node : graph[minValue]) {
                int end = node.end;
                int weight = node.weight;

                if (distance[end] > distance[minValue] + weight) {
                    distance[end] = distance[minValue] + weight;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int findMinValue() {
        int min = Integer.MAX_VALUE;
        int tmp = 0;
        for (int i = 1; i <= V; i++) {
            if (min > distance[i] && !visited[i]) {
                min = distance[i];
                tmp = i;
            }
        }

        return tmp;
    }
}

class Node {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}
