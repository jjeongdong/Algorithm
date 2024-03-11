import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        Stack<Character> stack = new Stack<>();


        for (int k = 0; k < size; k++) {

            String str = scanner.next();
            String answer = "YES";
            int count = 0;

            for (int i = 0; i < str.length(); i++) {
                stack.push(str.charAt(i));
            }
            for (int i = 0; i < str.length(); i++) {
                Character pop = stack.pop();

                if (pop == ')') {
                    count++;
                } else {
                    count--;
                }

                if (count < 0) {
                    answer = "NO";
                }
            }

            if (count != 0) {
                answer = "NO";
            }

            System.out.println(answer);
        }
    }
}
