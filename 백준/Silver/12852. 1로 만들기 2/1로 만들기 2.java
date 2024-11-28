import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // BFS를 위한 큐와 visited, parent 배열 초기화
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];
        int L = 0;
        boolean flag = false;

        // 시작점 초기화
        queue.add(n);
        visited[n] = true;
        parent[n] = -1; // 부모가 없음을 표시

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int now = queue.poll();

                if (now == 1) {
                    flag = true;
                    break; // 목표값 도달
                }

                // 3으로 나누는 경우
                if (now % 3 == 0 && !visited[now / 3]) {
                    queue.add(now / 3);
                    visited[now / 3] = true;
                    parent[now / 3] = now;
                }

                // 2로 나누는 경우
                if (now % 2 == 0 && !visited[now / 2]) {
                    queue.add(now / 2);
                    visited[now / 2] = true;
                    parent[now / 2] = now;
                }

                // 1을 빼는 경우
                if (now - 1 >= 1 && !visited[now - 1]) {
                    queue.add(now - 1);
                    visited[now - 1] = true;
                    parent[now - 1] = now;
                }
            }

            if (flag) break;
            L++;
        }

        // 최소 연산 횟수 출력
        System.out.println(L);

        // 경로 출력
        StringBuilder sb = new StringBuilder();
        int current = 1;
        Stack<Integer> path = new Stack<>();
        while (current != -1) {
            path.push(current);
            current = parent[current];
        }
        while (!path.isEmpty()) {
            sb.append(path.pop()).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
