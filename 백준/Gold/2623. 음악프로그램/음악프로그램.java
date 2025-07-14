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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        int[] indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int[] arr = new int[count];
            for (int j = 0; j < count; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < count; j++) {
                for (int k = j + 1; k < count; k++) {
                    A[arr[j]].add(arr[k]);
                    indegree[arr[k]]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append("\n");
            count++;
            for (int next : A[now]) {
                indegree[next]--;
                if (indegree[next] == 0) queue.add(next);
            }
        }

        if (count == N) {
            System.out.println(sb);
        } else {
            System.out.println(0);
        }
    }
}
