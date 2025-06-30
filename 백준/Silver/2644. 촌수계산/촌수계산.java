

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int startNum;
    static int targetNum;
    static int M;
    static ArrayList<Integer>[] A;
    static int[] dist;
    static boolean[] visited;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        startNum = Integer.parseInt(st.nextToken());
        targetNum = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        A = new ArrayList[N + 1];
        dist = new int[N + 1];
        visited = new boolean[N + 1];

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

        bfs();
        if (flag) System.out.println(dist[targetNum]);
        else System.out.println(-1);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNum);
        dist[startNum] = 0;
        visited[startNum] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == targetNum) {
                flag = true;
                break;
            }

            for (int i : A[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                    dist[i] = dist[now] + 1;
                }
            }
        }
    }
}
