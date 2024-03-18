import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num = 0;
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }

            if (command.equals("push_front")) {
                deque.addFirst(num);
            } else if (command.equals("push_back")) {
                deque.addLast(num);
            } else if (command.equals("pop_front")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.pollFirst()).append("\n");
                }
            } else if (command.equals("pop_back")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.pollLast()).append("\n");
                }
            } else if (command.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (command.equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (command.equals("front")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.getFirst()).append("\n");
                }
            } else if (command.equals("back")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.getLast()).append("\n");
                }
            }

        }

        System.out.println(sb);


    }
}
