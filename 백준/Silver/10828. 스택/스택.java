import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            } else if (command.equals("pop")) {
                if (!stack.isEmpty()) {
                    int val = stack.pop();
                    sb.append(val).append("\n");
                } else{
                    sb.append(-1).append("\n");
                }
            } else if (command.equals("size")) {
                int val = stack.size();
                sb.append(val).append("\n");;
            } else if (command.equals("empty")) {
                if (stack.isEmpty()) {
                    sb.append(1).append("\n");
                } else{
                    sb.append(0).append("\n");
                }
            } else if (command.equals("top")) {
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack.peek()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}