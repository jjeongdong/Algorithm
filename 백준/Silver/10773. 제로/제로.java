import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        int total = 0;
        while (!stack.isEmpty()) {
            int num = stack.pop();
            total += num;
        }

        System.out.println(total);
    }
}