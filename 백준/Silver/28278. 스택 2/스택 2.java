import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int command, num = 0;

        while (N != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if (st.countTokens() == 2) {
                command = Integer.parseInt(st.nextToken());
                num = Integer.parseInt(st.nextToken());
            } else {
                command = Integer.parseInt(st.nextToken());
            }

            if (command == 1) {
                stack.push(num);
            } else if (command == 2) {
                if (stack.empty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack.pop()).append("\n");
                }
            } else if (command == 3) {
                sb.append(stack.size()).append("\n");
            } else if (command == 4) {
                if (stack.empty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (command == 5) {
                if (stack.empty()) {
                    sb.append(-1).append("\n");
                } else {

                    sb.append(stack.peek()).append("\n");
                }
            }


            N--;


        }


        System.out.println(sb);

    }
}
