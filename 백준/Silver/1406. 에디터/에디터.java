import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        // 초기 문자열을 leftStack에 저장
        String initialString = br.readLine();
        for (char c : initialString.toCharArray()) {
            leftStack.push(c);
        }

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String line = br.readLine();

            char command = line.charAt(0);

            switch (command) {
                case 'L':
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;

                case 'D':
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;

                case 'B':
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;

                case 'P':
                    char newChar = line.charAt(2);
                    leftStack.push(newChar);
                    break;
            }
        }

        // leftStack과 rightStack을 합쳐서 결과를 출력
        StringBuilder result = new StringBuilder();
        while (!leftStack.isEmpty()) {
            result.append(leftStack.pop());
        }
        result.reverse(); // leftStack에서 꺼낸 문자열은 거꾸로 되어 있으므로 뒤집어줌

        while (!rightStack.isEmpty()) {
            result.append(rightStack.pop());
        }

        System.out.println(result);
    }
}
