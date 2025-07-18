import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        long[][] graph = new long[V + 1][V + 1];
        for (int i = 1; i < V + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start][end] = weight;
        }

        for (int k = 1; k <= V; k++) {
            for (int s = 1; s <= V; s++) {
                for (int e = 1; e <= V; e++) {
                    if (graph[s][e] > graph[s][k] + graph[k][e]) {
                        graph[s][e] = graph[s][k] + graph[k][e];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < V + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (i == j) min = Math.toIntExact(Math.min(min, graph[i][j]));
            }
        }

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
}

