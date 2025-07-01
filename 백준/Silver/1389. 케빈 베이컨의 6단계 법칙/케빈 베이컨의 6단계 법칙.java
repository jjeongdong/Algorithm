import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        int answer = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            int sum = bfs(i);
            if (min > sum) {
                min = sum;
                answer = i;
            }
        }

        System.out.println(answer);

    }

    private static int bfs(int number) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        visited[number] = true;

        queue.offer(number);
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            for (int i : A[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    distance[i] = distance[now] + 1;
                    queue.offer(i);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sum += distance[i];
        }
        return sum;
    }
}
