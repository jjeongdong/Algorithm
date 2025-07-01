import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N + 1];
        int[] result = new int[N + 1];
        int[] indegree = new int[N + 1];
        ArrayList<Integer>[] A = new ArrayList[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            
            while (true) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    break;
                }

                A[num].add(i);
                indegree[i]++;
            }

        }

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            for (int next : A[now]) {
                indegree[next]--;
                result[next] = Math.max(result[next], result[now] + times[now]);
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(times[i] + result[i]).append("\n");
        }

        System.out.println(sb);
    }
}
