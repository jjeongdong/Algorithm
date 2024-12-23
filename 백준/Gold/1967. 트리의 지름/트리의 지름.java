import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
5
1 3 2 -1
2 4 4 -1
3 1 2 4 3 -1
4 2 4 3 3 5 6 -1
5 4 6 -1
 */
public class Main {
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 시작 노드
            int end = Integer.parseInt(st.nextToken()); // 연결된 노드
            int weight = Integer.parseInt(st.nextToken()); // 가중치
            tree[start].add(new Node(end, weight)); // 그래프 저장
            tree[end].add(new Node(start, weight)); // 그래프 저장
        }


        for (int i = 1; i <= V; i++) {
            visited = new boolean[V + 1];
            visited[i] = true;
            DFS(i, 0);
        }

        System.out.println(max);
    }

    private static void DFS(int start, int total) {
        max = Math.max(max, total);

        for (Node node : tree[start]) {
            if (!visited[node.end]) {
                visited[node.end] = true;
                DFS(node.end, total + node.weight);
                visited[node.end] = false;
            }
        }
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
