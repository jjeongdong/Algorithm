import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static ArrayList<Edge> graph;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];
        graph = new ArrayList<>();

        int answer = 0;
        int cnt = 0;

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.add(new Edge(start, end, weight));
        }
        Collections.sort(graph);

        for (Edge edge : graph) {
            int start = edge.start;
            int end = edge.end;
            int weight = edge.weight;

            if (union(start, end)) {
                answer += weight;
                cnt++;
                if (cnt == V - 1) {
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean union(int a, int b) {
        int ua = find(a);
        int ub = find(b);

        if (ua < ub) {
            parent[ub] = ua;
        } else {
            parent[ua] = ub;
        }

        if (ua != ub) {
            return true;
        } else {
            return false;
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
