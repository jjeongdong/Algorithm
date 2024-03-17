import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder answer = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<') {

                while (!stack.empty()) {
                    answer.append(stack.pop());
                }


                while (str.charAt(i) != '>') {
                    answer.append(str.charAt(i++));
                }

                answer.append(str.charAt(i));

            } else if (Character.isAlphabetic(str.charAt(i)) || Character.isDigit(str.charAt(i))) {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ' ') {
                while (!stack.empty()) {
                    answer.append(stack.pop());
                }

                answer.append(' ');
            }
        }

        while (!stack.empty()) {
            answer.append(stack.pop());
        }

        System.out.println(answer);
    }
}
