import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        Stack<Double> stack = new Stack<>();
        char ch = 'A';

        HashMap<Character, Double> hashMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            hashMap.put(ch++, 0.00);
        }

        ch = 'A';
        for (int i = 0; i < N; i++) {
            hashMap.put(ch++, Double.parseDouble(br.readLine()));
        }

        for (int i = 0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) {
                stack.push(hashMap.get(str.charAt(i)));
            } else {
                double num2 = stack.pop();
                double num1 = stack.pop();

                if (str.charAt(i) == '+') {
                    stack.push(num1 + num2);
                } else if (str.charAt(i) == '-') {
                    stack.push(num1 - num2);
                } else if (str.charAt(i) == '*') {
                    stack.push(num1 * num2);
                } else if (str.charAt(i) == '/') {
                    stack.push(num1 / num2);
                }
            }
        }

        System.out.printf("%.2f%n", stack.pop());
    }
}
