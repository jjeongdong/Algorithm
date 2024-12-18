import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityCount = Integer.parseInt(st.nextToken());
        int streetCount = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());   // 거리 정보
        int X = Integer.parseInt(st.nextToken());   // 출발 정도

        ArrayList<Integer>[] graph = new ArrayList[cityCount + 1];
        for (int i = 1; i <= cityCount; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= streetCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }

        int[] distance = new int[cityCount + 1];
        Arrays.fill(distance, -1);
        distance[X] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (int next : graph[current]) {
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for (int i = 1; i <= cityCount; i++) {
            if (distance[i] == K) {
                found = true;
                sb.append(i).append("\n");
            }
        }

        if (!found) System.out.println(-1);
        else System.out.println(sb);
    }
}
