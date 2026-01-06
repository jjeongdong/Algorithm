import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static Deque<Character> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;
            sb.append(solve(str)).append("\n");
        }

        System.out.println(sb);
    }

    public static String solve(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);	

            // 여는 괄호일 경우 스택에 push 
            if(c == '(' || c == '[') {
                stack.push(c);
            }

            // 닫는 소괄호 일 경우 
            else if(c == ')') {

                // 스택이 비어있거나 pop할 원소가 소괄호랑 매칭이 안되는 경우 
                if(stack.empty() || stack.peek() != '(') {
                    return "no";
                } else {
                    stack.pop();
                }
            }

            else if(c == ']') {

                // 스택이 비어있거나 pop할 원소가 대괄호랑 매칭이 안되는 경우 
                if(stack.empty() || stack.peek() != '[') {
                    return "no";
                } else {
                    stack.pop();
                }
            }

        }

        if(stack.empty()) {
            return "yes";
        }
        else {
            return "no";
        }
    }

}