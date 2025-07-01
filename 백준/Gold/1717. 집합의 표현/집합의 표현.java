import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (op == 0) {
                union(x, y);
            } else if (op == 1) {
                int nx = find(x);
                int ny = find(y);

                if (nx == ny) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void union(int x, int y) {
        int nx = find(x);
        int ny = find(y);

        if (nx > ny) {
            parent[nx] = ny;
        } else {
            parent[ny] = nx;
        }
    }

    private static int find(int number) {
        if (number == parent[number]) {
            return number;
        }
        return parent[number] = find(parent[number]);
    }
}
