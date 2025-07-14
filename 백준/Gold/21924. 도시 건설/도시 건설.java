import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long sum = 0;

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        ArrayList<Edge> A = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            sum += w;

            A.add(new Edge(s, e, w));
        }

        long answer = 0;
        int cnt = 0;
        Collections.sort(A);
        for (int i = 0; i < M; i++) {
            Edge edge = A.get(i);
            if (union(edge.start, edge.end)) {
                answer += edge.weight;
                cnt++;
            }
        }

        if (cnt == N - 1) System.out.println(sum - answer);
        else System.out.println(-1);
    }

    public static boolean union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa == fb) {
            return false;
        } else {
            if (fa > fb) parent[fa] = fb;
            else parent[fb] = fa;
        }

        return true;
    }

    public static int find(int number) {
        if (number == parent[number]) return number;
        else return parent[number] = find(parent[number]);
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        long weight;

        public Edge(int start, int end, long weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }
}
