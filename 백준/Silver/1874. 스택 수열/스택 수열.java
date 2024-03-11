import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        StringBuilder answer = new StringBuilder();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = i + 1;
        }

        int idx = 0;
        Stack<Integer> stack = new Stack<>();

        try {
            for (int i = 0; i < size; i++) {
                int N = scanner.nextInt();

                while (stack.isEmpty() || stack.peek() != N) {
                    stack.push(arr[idx++]);
                    answer.append("+").append("\n");
                }

                if (stack.peek() == N) {
                    answer.append("-").append("\n");
                    stack.pop();
                }
            }

            System.out.println(answer);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("NO");
        }

    }
}
