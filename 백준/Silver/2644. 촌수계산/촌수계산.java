import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>()); // 각 정점을 위한 리스트 초기화
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        int L = 0;
        boolean flag = false;
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        visited[x] = true;
        queue.offer(x);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int now = queue.poll();

                int size = graph.get(now).size();
                for (int j = 0; j < size; j++) {
                    int tmp = graph.get(now).get(j);

                    if (tmp == y) {
                        flag = true;
                        break;
                    }

                    if (!visited[tmp]) {
                        visited[tmp] = true;
                        queue.offer(tmp);
                    }
                }
            }

            if (flag) break;
            L++;
        }

        if (!flag) System.out.println(-1);
        else System.out.println(L + 1);
    }
}
