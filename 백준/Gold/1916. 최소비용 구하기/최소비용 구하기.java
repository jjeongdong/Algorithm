import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 5
 * 8
 * 1 2 2
 * 1 3 3
 * 1 4 1
 * 1 5 10
 * 2 4 2
 * 3 4 1
 * 3 5 1
 * 4 5 3
 * 1 5
 */
public class Main {
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] distance;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 도시의 개수
        M = Integer.parseInt(br.readLine());    // 간선의 개수

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            if (i == startNode) {
                distance[i] = 0;
            } else {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < N; i++) {
            int minValue = findMinValue();
            visited[minValue] = true;

            if (graph[minValue] != null) {
                for (Node node : graph[minValue]) {
                    int end = node.end;
                    int weight = node.weight;
                    if (distance[end] > distance[minValue] + weight) {
                        distance[end] = distance[minValue] + weight;
                    }
                }
            }
        }

        System.out.println(distance[endNode]);
    }

    private static int findMinValue() {
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 1; i <= N; i++) {
            if (min > distance[i] && !visited[i]) {
                min = distance[i];
                idx = i;
            }
        }
        return idx;
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
