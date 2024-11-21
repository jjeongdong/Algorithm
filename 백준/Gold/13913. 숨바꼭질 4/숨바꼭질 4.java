import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] visit = new boolean[100001];
        int[] parent = new int[100001];
        boolean flag = false;
        int L = 0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visit[N] = true;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int now = queue.poll();

                if (now == K) {
                    flag = true;
                    break;
                }

                // 이동 가능한 경우 추가 (순서: *2, +1, -1)
                if (now * 2 <= 100000 && !visit[now * 2]) {
                    visit[now * 2] = true;
                    parent[now * 2] = now;
                    queue.add(now * 2);
                }
                if (now + 1 <= 100000 && !visit[now + 1]) {
                    visit[now + 1] = true;
                    parent[now + 1] = now;
                    queue.add(now + 1);
                }
                if (now - 1 >= 0 && !visit[now - 1]) {
                    visit[now - 1] = true;
                    parent[now - 1] = now;
                    queue.add(now - 1);
                }
            }

            if (flag) break;

            L++;
        }

        System.out.println(L);

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}
