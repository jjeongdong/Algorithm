import java.awt.print.Paper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Paper> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Paper(i, priority));
                pq.offer(priority);
            }

            int count = 0;
            while (!queue.isEmpty()) {
                Paper current = queue.poll();
                // 현재 문서 우선순위가 pq의 최대 우선순위와 같으면 출력
                if (current.priority == pq.peek()) {
                    pq.poll(); // 최대 우선순위 제거
                    count++;
                    if (current.index == M) {
                        sb.append(count).append("\n");
                        break;
                    }
                } else {
                    // 우선순위가 최대가 아니면 뒤로 보내기
                    queue.offer(current);
                }
            }
        }
        System.out.println(sb);
    }

    static class Paper {
        int index;
        int priority;

        public Paper(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

}
